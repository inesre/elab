package org.concord.coach.jna;

import static org.junit.Assert.*;

import java.io.IOException;

import org.concord.sensor.coach.jna.CoachHelperLibrary;
import org.concord.sensor.coach.jna.DeviceInfo;
import org.junit.Test;

public class CoachHelperTest {

	public CoachHelperLibrary cHelperL;
	
	public CoachHelperTest(){
		if (cHelperL ==null)
			try {
				cHelperL = CoachHelperLibrary.getInstance();
			} catch (IOException e) {
	
				e.printStackTrace();
				fail("Error when the CoachHelperLibrary is created: " + e.getMessage());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Error when the CoachHelperLibrary is created: " + e.getMessage());
			}
	}
	

	
	@Test
	public void testHelperLibraryIsEmpty() {
	
		assertNotNull("Error when the CoachHelperLibrary is created", cHelperL);
	
	}
	
	
	
	@Test
	public void testDetectNotConnectedDevices(){
		
	

		int max_devices=0;

		assertNull("detectedDevices with max_devices = "+ max_devices, cHelperL.detectDevices(max_devices));
	
		max_devices = 1;
		assertEquals("detectedDevices with max_devices = "+ max_devices, 0, cHelperL.detectDevices(max_devices).length);

		max_devices=-1;
		assertNull("detectedDevices with max_devices = "+ max_devices, cHelperL.detectDevices(max_devices));



		
	}
	
	
	
	@Test
	public void testDetectConnectedDevices(){
	

	
		DeviceInfo[] dev;
		int max_devices = 0;
		assertNull("detectedDevices with max_devices = "+ max_devices, cHelperL.detectDevices(max_devices));
		max_devices = 1;
		dev= cHelperL.detectDevices(max_devices);
		
		assertEquals("detectedDevices with max_devices = "+ max_devices,max_devices, dev.length);
		
		for(int i =0;i<dev.length;i++){
			assertNotNull("detectedDevices with max_devices = "+ max_devices+" has null elements", dev[i]);
		}
		
		max_devices = -1;
		assertNull("detectedDevices with max_devices = "+ max_devices, cHelperL.detectDevices(max_devices));
		
	}

	
	

}
