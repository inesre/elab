package org.concord.sensor.coach.jna;

public class ChannelKind {
	public final static byte NONE = -1;
	public final static byte DIGITAL_IN = 0;
	public final static byte DIGITAL_OUT = 1;
	public final static byte ANALOG_IN = 2; 
	public final static byte ANALOG_OUT = 3;
	public final static byte COUNTER_IN = 4;
	public final static byte ANALOG_AS_ONE_BIT_IN = 5;
	public final static byte ANALOG_AS_FREQUENCY_IN = 6;
	public final static byte STEP_COUNTERE_IN = 7;
	public final static byte NO_CHANNEL = 8;
	public final static byte ANALOG_AS_PERIOD_IN = 9;
}
