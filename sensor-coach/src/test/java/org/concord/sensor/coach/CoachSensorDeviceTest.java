package org.concord.sensor.coach;


import org.concord.sensor.device.SensorDeviceTest;

public class CoachSensorDeviceTest extends SensorDeviceTest {

	@Override
	public void setup() {
		device = new CoachSensorDevice();
	}

	@Override
	protected boolean supportsAttachingSingleTemperatureSensor() {
		return false;
	}
	
	@Override
	protected boolean supportsRawValueSensors() {
		return false;
	}
	
	
}