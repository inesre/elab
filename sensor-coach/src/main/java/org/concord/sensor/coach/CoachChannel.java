package org.concord.sensor.coach;

import org.concord.sensor.coach.jna.ChannelKind;
import org.concord.sensor.coach.jna.CoachException;
import org.concord.sensor.coach.jna.CoachLibrary;

public class CoachChannel {
	private byte channel;
	private byte channelKind;
	private CoachSensor sensor;
	private boolean measuring;
	private CoachLibrary library;

	/**
	 * 
	 * @param channel
	 * @param library
	 * @throws CoachException
	 */
	public CoachChannel(byte channel, CoachLibrary library) throws CoachException {
		if(channel < 0) throw new CoachException("Channel is negative");
		this.channel = channel;
		this.channelKind = ChannelKind.NONE;
		if(library==null) throw new IllegalArgumentException("Library is null");
		this.library = library;
		this.measuring=false;
	}
	/**
	 * 
	 * @return boolean saying if the channel is measuring
	 */
	public boolean isMeasuring(){
		return this.measuring;
	}
	/**
	 * 
	 * @param measuring boolean indicating if the channel is measuring
	 */
	public void setMeasuring(boolean measuring){
		this.measuring=measuring;
	}
	/**
	 * 
	 * @return detected sensor
	 * @see CoachSensor
	 * @see CoachLibrary#detectSensor(short)
	 */
	public CoachSensor detectSensor() {
		String uid;

		if ((uid = library.detectSensor(channel)) == null)
			return null;
		else
			return (sensor = new CoachSensor(this, uid));
	}

	/**
	 * 
	 * @return byte indicating the error
	 * @see CoachLibrary#connect(byte, short, boolean, boolean, boolean, String)
	 */
	public byte connectSensor() {
		// If the sensor was not detected before or was changed, the new one
		// will be connected
		if (sensor == null || library.connect(channelKind, channel, true, true, true, sensor.getUID()) != 0) {
			System.out.println("me caí");
			if (detectSensor() == null)
				return -1;
			return library.connect(channelKind, channel, true, true, true, sensor.getUID());
		}
		return 0;

	}

	/**
	 * 
	 * @return channel id (byte)
	 */
	public byte getChannel() {
		return this.channel;
	}

	/**
	 * 
	 * @return Associated sensor or null
	 * @see CoachSensor
	 */
	public CoachSensor getSensor() {
		return this.sensor;
	}

	/**
	 * 
	 * @return channelKind
	 * @see ChannelKind
	 */
	public byte getChannelKind() {
		return this.channelKind;
	}

	/**
	 * 
	 * @param channelKind
	 * @see ChannelKind
	 */
	void setChannelKind(byte channelKind) {
		if(-1<channelKind && channelKind<9) this.channelKind = channelKind;

	}

}
