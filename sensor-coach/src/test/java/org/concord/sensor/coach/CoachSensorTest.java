package org.concord.sensor.coach;


import static org.junit.Assert.*;


import java.io.IOException;

import org.concord.sensor.coach.jna.ChannelKind;
import org.concord.sensor.coach.jna.CoachException;
import org.concord.sensor.coach.jna.CoachHelperLibrary;
import org.concord.sensor.coach.jna.DeviceInfo;
import org.junit.Before;
import org.junit.Test;


public class CoachSensorTest {

	
	CoachChannel channel;
	String uid;
	CoachSensor sensor;
	
	@Before
	public void initializeParameters() throws CoachException{
		try {
			CoachHelperLibrary lib =CoachHelperLibrary.getInstance();
			DeviceInfo dInfo = lib.detectFirstDevice();
			CoachDevice dev = new CoachDevice(dInfo.getDeviceType(),lib.getDirectory());
			channel = dev.getChannels()[0];
		} catch (IOException e) {

			e.printStackTrace();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**test with sensor connected to the first channel**/
	@Test
	public void testCoachSensor() {
		uid = channel.detectSensor().getUID();
		
		sensor = new CoachSensor(channel, uid);
		assertNotSame("Sensor is not recognized",ChannelKind.NONE, channel.getChannelKind());
		
		sensor = new CoachSensor(channel, "");
		assertSame("Sensor is recognized with uid=\"\"",ChannelKind.NONE, channel.getChannelKind());
		
		try{
			sensor = new CoachSensor(null,uid);
			fail("Expected IllegalArgumentException (channel == null)");
		}catch(IllegalArgumentException e){
			
		}
		
		try{
			sensor = new CoachSensor(channel,null);
			fail("Expected IllegalArgumentException (uid == null)");
		}catch(IllegalArgumentException e){
			
		}
		
	
	}

}
