package org.concord.sensor.coach;

import org.concord.sensor.device.ExampleSensorApp;
import org.concord.sensor.device.impl.DeviceID;

public class CoachSensorExampleApp extends ExampleSensorApp {

	@Override
	public void setup() {
		deviceId = DeviceID.COACH;
	}

	public static void main(String[] args) {
		CoachSensorExampleApp app = new CoachSensorExampleApp();
		app.testAllConnectedProbes();
	}	
}
