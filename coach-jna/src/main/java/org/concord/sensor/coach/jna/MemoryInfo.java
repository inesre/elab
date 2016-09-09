package org.concord.sensor.coach.jna;

import com.sun.jna.Memory;
/**
 * This class is necessary for keeping the information about the detected devices
 * @see CoachHelperJNA
 *
 */
public class MemoryInfo extends Memory{
	
	private DeviceInfo[] devices;
	private int size;
	/**
	 * Constructor of MemoryInfo
	 * @param max_devices number max of deviced
	 */
	public MemoryInfo(long max_devices){
		super(6*max_devices);
		if(max_devices<=0) throw new IllegalArgumentException("max_devices should be positive");
		this.size = (int) max_devices;

	}

	public void clearDevices(){
		this.devices = null;
		//this.clear();
	}
	public DeviceInfo[] getDeviceInfoKept(){
		return devices;
	}
	/**
	 * 
	 * @param numDevices
	 * @return array of DeviceInfo
	 * @see DeviceInfo
	 * 
	 */
	public DeviceInfo[] getDeviceInfo(int numDevices) throws IllegalArgumentException{
		if(numDevices<0) throw new IllegalArgumentException("numDevices should be positive");
		int num = size;
		if (num>numDevices) num = numDevices;
		this.devices = new DeviceInfo[numDevices];
		int productID, deviceID, release;
		byte [] buf = new byte[num*6];
		this.read(0, buf, 0, num*6);
		//interpreting buf
		for(int i = 0 ; i<num*6 && i<numDevices*6; i+=6){
			deviceID = buf[0]+ (buf[1]*256);
			productID = buf[2]+ (buf[3]*256);
			release = buf[4]+ (buf[5]*256);
			this.devices[(i/6)] = new DeviceInfo(productID, deviceID, release);
		}
		for(int i = num; i<numDevices;i++){
			this.devices[i] = new DeviceInfo(0, 0, 0);
		}
		return this.devices;
		
	}
	

}