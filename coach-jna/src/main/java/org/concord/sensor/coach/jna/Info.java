package org.concord.sensor.coach.jna;
/**
 * It's necessary to take the info about the channels of the connected device
 * 
 *@see CoachJNA#GetInfo(byte[], byte[], byte[], byte[], byte[], byte[])
 */
public class Info {

	
	private byte[] digi;
	private byte[] digo;
	private byte[] anali;
	private byte[] analo;
	private byte[] counter;
	private byte[] stepcounter;
	
	public Info(){
		
		this.digi= new byte[1];
		this.digo= new byte[1];
		this.anali= new byte[1];
		this.analo= new byte[1];
		this.counter= new byte[1];
		this.stepcounter= new byte[1];
	}
	
	
	
	public byte[] getDigitalIn(){
		return this.digi;
	}
	public byte[] getDigitalOut(){
		return this.digo;
	}
	public byte[] getAnalogIn(){
		return this.anali;
	}
	public byte[] getAnalogOut(){
		return this.analo;
	}
	public byte[] getCounter(){
		return this.counter;
	}
	public byte[] getStepCounter(){
		return this.stepcounter;
	}
	
	
}
