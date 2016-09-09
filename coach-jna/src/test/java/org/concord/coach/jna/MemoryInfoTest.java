package org.concord.coach.jna;

import static org.junit.Assert.*;

import org.concord.sensor.coach.jna.DeviceInfo;
import org.concord.sensor.coach.jna.MemoryInfo;
import org.junit.Test;

public class MemoryInfoTest {

	@Test
	public void testMemoryInfo() {

		Exception e1=null;
		try{
			new MemoryInfo(0);
			new MemoryInfo(-1);
		}catch(IllegalArgumentException e){
			e1=e;
		}
		if(e1==null) fail("0 or less is not valid for maxDevices");
		try{
			new MemoryInfo(2);
		}catch(IllegalArgumentException e){
			fail("number greater than 0 is valid for maxDevices");
		}
		
		

	}

	@Test
	public void testGetDeviceInfo() {
		MemoryInfo mInfo = new MemoryInfo(2);
		
		Exception e1=null;
		try{
			mInfo.getDeviceInfo(0);
			mInfo.getDeviceInfo(-1);
		}catch(IllegalArgumentException e){
			e1=e;
		}
		if(e1==null) fail("0 or less is not valid for numDevices");
		DeviceInfo[] devInfo;
		try{
			devInfo = mInfo.getDeviceInfo(1);
			assertNotNull("getDeviceInfo returns null with numDevices 1 and max_devices 2",devInfo);
			for(int i = 0; i<devInfo.length; i++){
				assertNotNull("holii"+ i,devInfo[i]);
			}
			devInfo = mInfo.getDeviceInfo(2);
			assertNotNull("getDeviceInfo returns null with numDevices 2 and max_devices 2",devInfo);
			for(int i = 0; i<devInfo.length; i++){
				assertNotNull("holii"+ i,devInfo[i]);
			}
		
			devInfo = mInfo.getDeviceInfo(4);
			assertNotNull("getDeviceInfo returns null with numDevices 4 and max_devices 2",devInfo);
			for(int i = 0; i<devInfo.length; i++){
				assertNotNull(devInfo[i]);
			}
		}catch(IllegalArgumentException e){
			fail("number greater than 0 is valid for numDevices");
		}
	}

}
