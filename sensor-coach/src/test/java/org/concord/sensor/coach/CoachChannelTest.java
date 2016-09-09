package org.concord.sensor.coach;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.concord.sensor.coach.jna.CoachException;
import org.concord.sensor.coach.jna.CoachHelperLibrary;
import org.concord.sensor.coach.jna.CoachLibrary;
import org.concord.sensor.coach.jna.DeviceInfo;
import org.junit.Test;

public class CoachChannelTest {

	CoachDevice device;
	CoachChannel channel;
	String uid;
	CoachSensor sensor;
	CoachLibrary library;


	String lastUserMessage;
	
	public void initializeParameters() throws CoachException{
		try {
			CoachHelperLibrary lib =CoachHelperLibrary.getInstance();
			DeviceInfo dInfo = lib.detectFirstDevice();
			
			device = new CoachDevice(dInfo.getDeviceType(),lib.getDirectory());
			channel = device.getChannels()[0];
			
		} catch (IOException e) {

			e.printStackTrace();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@Test
	public void testCoachChannel() {
		tellUserToAttachTheDevice();
		try {
			initializeParameters();

			channel = new CoachChannel((byte) 1, device.getLibrary());
			
		} catch (CoachException e) {
			
			fail(e.getMessage());
		}catch(IllegalArgumentException e){
			fail(e.getMessage());
		}
		try {
			

			channel = new CoachChannel((byte) 1, null);
			fail("library is null when the channel is created");
		} catch (CoachException e) {
			
			fail(e.getMessage());
		}catch(IllegalArgumentException e){
		}
		
		try {
			

			channel = new CoachChannel((byte) -1, null);
			fail("ch is negative when the channel is created");
		} catch (CoachException e) {
			
		
		}catch(IllegalArgumentException e){
			fail(e.getMessage());
		}
	}



	@Test
	public void testDetectSensor() {
		tellUserToAttachTheDeviceWith("without sensor in the channel 1");
		try {
			initializeParameters();
		} catch (CoachException e) {
			fail(e.getMessage());
		}
		
		assertNull("Detected sensor in channel 1",channel.detectSensor());
		
		tellUserToAttachTheDeviceWith("with a sensor in the channel 1");
		assertNotNull("Not detected sensor in channel 1",channel.detectSensor());
		
	}

	@Test
	public void testConnectSensor() {
		tellUserToAttachTheDevice();
		try {
			initializeParameters();
		} catch (CoachException e) {
			fail(e.getMessage());
		}

		tellUserToAttachTheDeviceWith("with a sensor in the channel 1");

		assertNotSame("Not detected sensor in channel 1",-1,channel.connectSensor());
		
		tellUserToAttachTheDeviceWith("without sensor in the channel 1");

		assertEquals("Detected sensor in channel 1",-1,channel.connectSensor());

	}

	@Test
	public void testSetChannelKind() {
		tellUserToAttachTheDevice();
		try {
			initializeParameters();
		} catch (CoachException e) {
			fail(e.getMessage());
		}
		
		channel.setChannelKind((byte) -3);
		byte a = channel.getChannelKind();
		assertTrue("channelkind is out of range", a!=-3 && -2<a && a<10);
		
		channel.setChannelKind((byte) 5);
		a = channel.getChannelKind();
		assertTrue("channelkind is out of range", a==5);
		
		channel.setChannelKind((byte) 10);
		a = channel.getChannelKind();
		assertTrue("channelkind is out of range", a!=10 && -2<a && a<10);

		
	}
	
	protected void tellUser(String message) {
		if(message.equals(lastUserMessage)){
			return;
		}
		JOptionPane.showMessageDialog(null, message);
		lastUserMessage = message;
	}
	
	protected void tellUserToAttachTheDevice() {
		tellUser("Attach the " + getDeviceLabel());
	}
	
	protected void tellUserToAttachTheDeviceWith(String message) {
		tellUser("Attach the " + getDeviceLabel() + message);
	}
	
	protected void tellUserToDetachTheDevice() {
		tellUser("Detach the " + getDeviceLabel());
	}
	

	protected String getDeviceLabel(){
		return "Coach usb ";
	}
	


}
