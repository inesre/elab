package org.concord.sensor.coach;

import java.util.ArrayList;
import java.util.Vector;

import org.concord.sensor.SensorConfig;
import org.concord.sensor.coach.jna.CoachException;
import org.concord.sensor.coach.jna.CoachLibrary;
import org.concord.sensor.coach.jna.Info;

public class CoachDevice {

	private CoachLibrary library;
	private String deviceName;
	private CoachChannel[] channels;
	private String errorMessage;
	private int lastMeasurement;
	
	
	
	public CoachDevice(String deviceName,String directory) throws CoachException {
		
		library = CoachLibrary.getInstance();
		try {

			library.initLibrary(deviceName, directory);
			library.initialize();
	
		} catch (Exception e) {
			errorMessage = "Can't load native library";
			library = null;
			e.printStackTrace();
		}
		this.lastMeasurement=0;
		
		Info info = library.getInfo();
		int size = info.getAnalogOut()[0] + info.getDigitalOut()[0];
		this.channels = new CoachChannel[size];
		this.deviceName = library.getDeviceName();
		detectChannels();


	}
	
	
	
	public int read(float[] values, int offset, int nextSampleOffset){
		CoachChannel channel;
		int i = 0;
		Vector<CoachChannel> measuring = getChannelsMeasuring();
		int numMeasurement=library.getNumberMeasurement();
		if(numMeasurement-lastMeasurement >values.length) numMeasurement = values.length+lastMeasurement; 
		
		if (library.measuringIsRunning()) {
			for (i =0 ; i < (numMeasurement-lastMeasurement); i+=nextSampleOffset) {
			
				for (int num = 0; num < nextSampleOffset; num++) {
					channel = measuring.get(num);
					if (channel.getSensor() != null) {
						
						values[num + i] = library.getMeasurementEx(lastMeasurement + i, channel.getChannel());
					}
					else values[num + i] =0;

				}
			}

		} else {
			activateMeasurement();

			return 0;
		}
		lastMeasurement = numMeasurement;
		return (i) / nextSampleOffset;

	}
	
	
	
	
	
	

	private Vector<CoachChannel> getChannelsMeasuring() {
		Vector<CoachChannel> measuring = new Vector<CoachChannel>();
		for (int i = 0; i < channels.length; i++) {
			if (channels[i].isMeasuring())
				measuring.add(channels[i]);
		}
		return measuring;
	}

	public void activateMeasurement() {
		short maxChannel=0,noCh=0;
		for (CoachChannel ch : channels) {
			if (ch.connectSensor() != -1) {
				if (ch.getChannel() > maxChannel)
					maxChannel = ch.getChannel();
				ch.setMeasuring(true);

			}
		}
		library.startMeasurement((float) 100.0, 2000000,maxChannel, noCh, noCh, noCh, noCh, noCh);

	}

	public String getDeviceName() {
		return this.deviceName;
	}

	/**
	 * @throws CoachException 
	 * 
	 */
	public void detectChannels() throws CoachException {

		for (byte ch = 1; ch <= channels.length; ch++) {

			channels[ch - 1] = new CoachChannel(ch, library);
		}

	}

	/**
	 * 
	 * @return
	 */
	public CoachLibrary getLibrary() {
		return this.library;
	}


	public void open(short ch) {

		if ((channels[ch]).connectSensor() != 0)
			errorMessage="Not connected sensor in channel " + ch;

	}

	public CoachChannel[] getChannels() {

		return channels;
	}

	public SensorConfig[] getSensorConfigs() {
		CoachSensor sensor;
		ArrayList<CoachSensor> sensorConfigList = new ArrayList<CoachSensor>();

		// device.clearAll();

		for (CoachChannel channel : channels) {

			if ((sensor = channel.detectSensor()) != null) {
				sensorConfigList.add(sensor);
			}

		}
		return sensorConfigList.toArray(new SensorConfig[0]);

	}



	



	public void stopMeasurement() {

		library.stopMeasurement();

		
	}



	public String getErrorMessage() {
		return errorMessage;
	}

	public void close(){
		this.stopMeasurement();
		for(CoachChannel ch : channels){
			if(ch.getSensor()!=null) library.disconnectChannel(ch.getChannelKind(),ch.getChannel());
			
		}
		library.close();

	}

}
