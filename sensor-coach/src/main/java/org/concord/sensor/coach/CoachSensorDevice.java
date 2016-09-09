package org.concord.sensor.coach;

import java.io.IOException;

import org.concord.sensor.ExperimentConfig;
import org.concord.sensor.ExperimentRequest;
import org.concord.sensor.coach.jna.CoachException;
import org.concord.sensor.coach.jna.CoachHelperLibrary;
import org.concord.sensor.coach.jna.DeviceInfo;
import org.concord.sensor.device.DeviceReader;
import org.concord.sensor.device.impl.AbstractSensorDevice;
import org.concord.sensor.device.impl.SerialPortParams;
import org.concord.sensor.impl.ExperimentConfigImpl;

public class CoachSensorDevice extends AbstractSensorDevice {


	private String errorMessage;

	private CoachHelperLibrary helperLib;
	private CoachDevice device;
	private String deviceName = "usb";


	public CoachSensorDevice() {

		if (helperLib == null) {
			
			// Only the first time
			
				
				try {
					helperLib = (CoachHelperLibrary) CoachHelperLibrary.getInstance();	
					DeviceInfo dev;
					if((dev = helperLib.detectFirstDevice())!=null) {

						deviceName = dev.getDeviceType();
						device = new CoachDevice(deviceName, helperLib.getDirectory());
					}
				
				} catch (IOException e) {
					errorMessage = "Can't load native library";
					helperLib = null;
					e.printStackTrace();
				} catch (CoachException e) {
					errorMessage = "Can't load native library";
					helperLib = null;
					e.printStackTrace();
				} catch (InterruptedException e) {
					errorMessage = "Can't load native library";
					helperLib = null;
					e.printStackTrace();
				}
				
		
		}

		

	}



	public void open(short ch) {

		device.open(ch);

	}

	public CoachSensorDevice newInstance() {
		return this;
	}

	public String getVendorName() {

		return "coach";
	}

	public String getDeviceName() {
		return deviceName;//"usb";
	}

	public ExperimentConfig configure(ExperimentRequest request) {
		return autoIdConfigure(request);
	}

	public boolean start() {



		device.activateMeasurement();

		return true;
	}
	
	
	public int read(float[] values, int offset, int nextSampleOffset, DeviceReader reader) {
		return device.read(values,offset,nextSampleOffset);
	}

	public void stop(boolean wasRunning) {
		
		device.stopMeasurement();
		

	}

	public String getErrorMessage(int error) {
		return errorMessage;
	}

	/**
	 * @see org.concord.sensor.device.impl.AbstractSensorDevice#canDetectSensors()
	 */
	public boolean canDetectSensors() {
		return true;
	}

	public ExperimentConfig getCurrentConfig() {

		ExperimentConfigImpl expConfig = new ExperimentConfigImpl();

		expConfig.setDeviceName(getVendorName() + " " + getDeviceName());
		expConfig.setValid(true);
		expConfig.setSensorConfigs(device.getSensorConfigs());
	

		return expConfig;
	}


	@Override
	protected boolean initializeOpenPort(String portName) {
		return false;
	}

	@Override
	protected SerialPortParams getSerialPortParams() {

		return null;
	}

	
	protected boolean openPort() {
		if (device == null||device.getDeviceName()=="none") {
			device =null;
			errorMessage = "Can't find an attached Coach device";
			return false;
		}

		//deviceName = device.getDeviceName();
		return true;

	}
	@Override
	public void close() {
	
		
			device.close();
			device=null;
	
	}
	@Override
	public boolean isAttached() {
		if(device == null){
			return false;
		}
		try {
			DeviceInfo[] dInfo = helperLib.detectAllDevices();
			for(DeviceInfo dev : dInfo){
			
				if((dev.getDeviceType()).equals(deviceName))return true;
			}
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoachException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}