package org.concord.coach.jna;

import static org.junit.Assert.*;

import java.io.IOException;

import org.concord.sensor.coach.jna.CoachException;
import org.concord.sensor.coach.jna.CoachHelperLibrary;
import org.concord.sensor.coach.jna.CoachLibrary;
import org.concord.sensor.coach.jna.DeviceInfo;
import org.concord.sensor.coach.jna.Info;
import org.junit.BeforeClass;
import org.junit.Test;

public class CoachLibraryExampleTesting {
	//It's necessary to have at least a connected device
	private CoachLibrary cLibrary;
	private static String deviceName; 
	private static String directory;
	
	
	public CoachLibraryExampleTesting(){
		if (cLibrary ==null){
			cLibrary = CoachLibrary.getInstance();
			assertNotNull("Error when the library is created", cLibrary);
		}
	}
	

	@BeforeClass
	public static void beforeCoachLibrary(){
		CoachHelperLibrary cHelperL;
		try {
			cHelperL = CoachHelperLibrary.getInstance(); /*verified in CoachHelperTesting*/
			DeviceInfo devInfo = cHelperL.detectFirstDevice();
			directory = cHelperL.getDirectory();
			deviceName = devInfo.getDeviceType();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoachException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*public void testInitLibrary(){
		Info info = cLibrary.getInfo();
		int numChannels =info.getAnalogIn()[0] + info.getAnalogOut()[0]+ info.getDigitalIn()[0]+info.getDigitalOut()[0]+info.getCounter()[0]+info.getStepCounter()[0];
		for(int i = 1; i <= numChannels; i++){
			//cLibrary.detectSensor();
		}
		
	}*/
	
	@Test
	public void testInitLibrary(){
		try {
			cLibrary.initLibrary(deviceName, directory);
		} catch (IOException  e) {

			e.printStackTrace();
			fail(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	@Test
	public void testChannelsExampleDevice(){
		Info info = cLibrary.getInfo();
		assertNotNull("Info about the device is null", info);
		
		int auxNum = info.getAnalogIn()[0];
		assertTrue("Negative number of Analog Input Channels",0<=auxNum);
		int numChannels = auxNum;
		
		auxNum = info.getAnalogOut()[0];
		assertTrue("Negative number of Analog Output Channels",0<=auxNum);
		numChannels += auxNum;
		
		auxNum = info.getDigitalIn()[0];
		assertTrue("Negative number of Digital Input Channels",0<=auxNum);
		numChannels += auxNum;
		
		auxNum = info.getDigitalOut()[0];
		assertTrue("Negative number of Digital Output Channels",0<=auxNum);
		numChannels += auxNum;
		
		auxNum = info.getCounter()[0];
		assertTrue("Negative number of Counter Channels",0<=auxNum);
		numChannels += auxNum;
		
		auxNum = info.getStepCounter()[0];
		assertTrue("Negative number of Step Counter Channels",0<=auxNum);
		numChannels += auxNum;
		
		assertTrue("Negative number of channels",0<numChannels);
		
		cLibrary.initialize();

		
	}

	

	
	
	

}
