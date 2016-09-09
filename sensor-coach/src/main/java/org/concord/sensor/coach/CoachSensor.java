package org.concord.sensor.coach;


import org.concord.sensor.coach.jna.ChannelKind;
import org.concord.sensor.device.impl.SensorConfigImpl;
/**
 * This class represents a sensor defined by an uid
 * @see SensorConfigImpl
 *
 */
public class CoachSensor extends SensorConfigImpl{

	private String uid;


	
	public CoachSensor(CoachChannel channel, String uid) {
		if(channel==null || uid==null) throw new IllegalArgumentException();
		setConfirmed(true); //We looked for before call this constructor
		channel.setChannelKind(configureSensor(uid));
		this.uid =uid;
	}
	public String getUID(){
		return this.uid;
	}

	
	private byte configureSensor(String uid){

		if ("E7A8AE648E".equals(uid)) {
			setType(QUANTITY_TEMPERATURE_WAND);
			setName("Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("C9E5B5BE32".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("3-Axis Accelerometer (Y)");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("89BE67976E".equals(uid)) {
			setType(QUANTITY_LIGHT);
			setName("Light Sensor with 3 ranges");
			setUnit("lx");
			return ChannelKind.ANALOG_IN;
		} else if ("686D002B34".equals(uid)) {
			setType(QUANTITY_FORCE);
			setName("Force sensor");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("EE42DA6A09".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("Low g Accelerometer");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("8ABFC0A378".equals(uid)) {
			setType(QUANTITY_FORCE);
			setName("Force sensor (Dual range)");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("7A2C2F143A".equals(uid)) {
			setType(QUANTITY_VELOCITY);// 7 counter -- QUANTITY_DISTANCE??
			setName("Photogate");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("1EFB438DAA".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//26 switch 
			setName("Photogate");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("FEFBC30A8C".equals(uid)) {
			setType(QUANTITY_PULSE_RATE);
			setName("Heartbeat sensor");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("9A652743B5".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Chloride sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("EA4CB667B4".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Charge sensor");
			setUnit("nC");
			return ChannelKind.ANALOG_IN;
		} else if ("1A1A2B450D".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Nitrate sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("8A6BFCF431".equals(uid)) {
			setType(QUANTITY_COLORIMETER);
			setName("Colorimeter 470nm");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("655DDA7A55".equals(uid)) {
			setType(QUANTITY_OXYGEN_GAS);
			setName("Oxygen sensor (gas)");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("DE4403A721".equals(uid)) {
			setType(QUANTITY_FORCE);
			setName("Force sensor");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("E48F4C434A".equals(uid)) {
			setType(QUANTITY_DISSOLVED_OXYGEN);
			setName("Dissolved Oxygen sensor");
			setUnit("mg/L");
			return ChannelKind.ANALOG_IN;
		} else if ("05879408E9".equals(uid)) {
			setType(QUANTITY_CONDUCTIVITY);
			setName("Conductivity sensor");
			setUnit("µS");
			return ChannelKind.ANALOG_IN;
		} else if ("5D4AB585B8".equals(uid)) {
			setType(QUANTITY_VOLTAGE);
			setName("Voltage sensor (differential)");
			setUnit("mV");
			return ChannelKind.ANALOG_IN;
		} else if ("66A3FA5299".equals(uid)) {
			setType(QUANTITY_UNKNOWN);
			setName("Chloride sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("9FFE0364B4".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("3-Axis Accelerometer (Z)");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("72C97B6052".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("3-Axis Accelerometer (Z)");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("903CF38353".equals(uid)) {
			setType(QUANTITY_CO2_GAS);
			setName("CO2 sensor");
			setUnit("ppm");
			return ChannelKind.ANALOG_IN;
		} else if ("F11433CDA9".equals(uid)) {
			setType(QUANTITY_GAS_PRESSURE);
			setName("Pressure sensor");
			return ChannelKind.ANALOG_IN;
		} else if ("C5E1DDA8D9".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//26 --
			setName("Switch");
			setUnit("V");
			return ChannelKind.ANALOG_IN;
		} else if ("555ED60FF1".equals(uid)) {
			setType(QUANTITY_TEMPERATURE_WAND);
			setName("Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("53FAD6D49D".equals(uid)) {
			setType(QUANTITY_PH);
			setName("pH sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("B3257B53AF".equals(uid)) {
			setType(QUANTITY_VOLTAGE);
			setName("Voltage sensor");
			setUnit("V");
			return ChannelKind.ANALOG_IN;//Analog10
		} else if ("80FA74818C".equals(uid)) {
			setType(QUANTITY_TEMPERATURE_WAND);
			setName("Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("E63777FF18".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//7 Counter
			setName("Drop Counter (digital)");
			setUnit("");
			return ChannelKind.DIGITAL_IN;
		} else if ("009F12E811".equals(uid)) {
			setType(QUANTITY_SOUND_INTENSITY);
			setName("Sound sensor");
			setUnit("Pa");
			return ChannelKind.ANALOG_IN;
		} else if ("4EF39FBA4B".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Ammonium sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("E51FB1B2CE".equals(uid)) {
			setType(QUANTITY_FORCE);
			setName("Force sensor");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("7062A8B815".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Calcium sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("47C48A63EB".equals(uid)) {
			setType(QUANTITY_SOUND_INTENSITY);
			setName("Sound sensor");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("546C31D6E8".equals(uid)) {
			setType(QUANTITY_ANGULAR_VELOCITY);
			setName("Rotary Motion sensor");
			setUnit("°");
			return ChannelKind.DIGITAL_IN;
		} else if ("C63624A093".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("Low g Accelerometer");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("639FE74AC1".equals(uid)) {
			setType(QUANTITY_EKG);
			setName("EKG sensor");
			setUnit("mV");
			return ChannelKind.ANALOG_IN;
		} else if ("273043771E".equals(uid)) {
			setType(QUANTITY_CO2_GAS);
			setName("CO2 sensor");
			setUnit("ppm");
			return ChannelKind.ANALOG_IN;
		} else if ("54CBB714E5".equals(uid)) {
			setType(QUANTITY_LIGHT);
			setName("Light sensor");
			setUnit("klx");
			return ChannelKind.ANALOG_IN;
		} else if ("008AC03B34".equals(uid)) {
			setType(QUANTITY_WIND_SPEED);
			setName("Flow rate sensor");
			setUnit("m/s");
			return ChannelKind.ANALOG_IN;
		} else if ("9297047D8D".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//22 Radiactivity
			setName("Geiger-M�ller Operating Voltage sensor");
			setUnit("V");
			return ChannelKind.ANALOG_IN;
		} else if ("6D1400D4C5".equals(uid)) {
			setType(QUANTITY_LIGHT);
			setName("Light sensor");
			setUnit("lx");
			return ChannelKind.ANALOG_IN;
		} else if ("7E9E398A55".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("3-Axis Accelerometer (Y)");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("AC0DD18C98".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Charge sensor");
			setUnit("nC");
			return ChannelKind.ANALOG_IN;
		} else if ("392F083749".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("3-Axis Accelerometer (X)");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("BCCD545ED2".equals(uid)) {
			setType(QUANTITY_COLORIMETER);
			setName("Colorimeter (4 colors)");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("0AF7401A21".equals(uid)) {
			setType(QUANTITY_RELATIVE_HUMIDITY);
			setName("Humidity sensor");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("BC017CE788".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//22 Radiactivity
			setName("Geiger-Möller sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;//Analog10
		} else if ("12752716DF".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("ORP sensor");
			setUnit("mV");
			return ChannelKind.ANALOG_IN;
		} else if ("671BE7B66E".equals(uid)) {
			setType(QUANTITY_LIGHT);
			setName("Light sensor");
			setUnit("W/m2");
			return ChannelKind.ANALOG_IN;
		} else if ("CD91AB8481".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//26 Switch
			setName("Switch");
			setUnit("V");
			return ChannelKind.ANALOG_IN;
		} else if ("A09D697E62".equals(uid)) {
			setType(QUANTITY_UVB_INTENSITY);
			setName("UVB sensor");
			setUnit("mW/m2");
			return ChannelKind.ANALOG_IN;
		} else if ("AF6FD41A07".equals(uid)) {
			setType(QUANTITY_DISTANCE);
			setName("Ultrasonic Motion Detector");
			setUnit("m");
			return ChannelKind.ANALOG_IN;
		} else if ("14DA950A06".equals(uid)) {
			setType(QUANTITY_ANGULAR_VELOCITY);//QUANTITY_COMPASS?
			setName("Angle position sensor");
			setUnit("°");
			return ChannelKind.ANALOG_IN;
		} else if ("157A843D05".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("Low g Accelerometer");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("A9B981E717".equals(uid)) {
			setType(QUANTITY_SALINITY);
			setName("Salinity sensor");
			setUnit("ppt");
			return ChannelKind.ANALOG_IN;
		} else if ("9EA9769687".equals(uid)) {
			setType(QUANTITY_CO2_GAS);
			setName("CO2 sensor");
			setUnit("ppm");
			return ChannelKind.ANALOG_IN;//aquiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
		} else if ("FF87000000".equals(uid)) {
			setType(QUANTITY_HEART_RATE_SIGNAL);
			setName("Exercise Heart Rate sensor");
			setUnit("bpm");
			return ChannelKind.ANALOG_IN;
		} else if ("62D338CBB8".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Charge sensor");
			setUnit("nC");
			return ChannelKind.ANALOG_IN;
		} else if ("D9FCB8F81B".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Calcium sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("54F22A506E".equals(uid)) {
			setType(QUANTITY_UVB_INTENSITY);
			setName("UVB sensor");
			setUnit("mW/m2");
			return ChannelKind.ANALOG_IN;
		} else if ("B94385B7C1".equals(uid)) {
			setType(QUANTITY_VOLTAGE);
			setName("Voltage sensor");
			setUnit("V");
			return ChannelKind.ANALOG_IN;
		} else if ("7AE495F128".equals(uid)) {
			setType(QUANTITY_GAS_PRESSURE);
			setName("Baro sensor");
			setUnit("kPa");
			return ChannelKind.ANALOG_IN;
		} else if ("110D92CD70".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("3-Axis Accelerometer (Y)");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("31B5356410".equals(uid)) {
			setType(QUANTITY_SALINITY);
			setName("Gas Pressure sensor");
			setUnit("kPa");
			return ChannelKind.ANALOG_IN;
		} else if ("F63B163E59".equals(uid)) {
			setType(QUANTITY_SOUND_INTENSITY);
			setName("Sound sensor");
			setUnit("Pa");
			return ChannelKind.ANALOG_IN;
		} else if ("B005545B41".equals(uid)) {
			setType(QUANTITY_GAS_PRESSURE);
			setName("Pressure sensor");
			setUnit("bar");
			return ChannelKind.ANALOG_IN;
		} else if ("131D795615".equals(uid)) {
			setType(QUANTITY_FORCE);
			setName("Force sensor (Dual range)");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("C89CC63451".equals(uid)) {
			setType(QUANTITY_FORCE);//31 BALANCE
			setName("Balance sensor");
			setUnit("g");
			return ChannelKind.ANALOG_IN;
		} else if ("73964E7993".equals(uid)) {
			setType(QUANTITY_COLORIMETER);
			setName("Colorimeter (4 colors)");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("FBC1D73A1B".equals(uid)) {
			setType(QUANTITY_LIGHT);
			setName("Light sensor");
			setUnit("lx");
			return ChannelKind.ANALOG_IN;
		} else if ("A0A0BDDE3C".equals(uid)) {
			setType(QUANTITY_FORCE);
			setName("Force sensor (Dual range)");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("728FF721C9".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("3-Axis Accelerometer (Z)");
			setUnit("g");
			return ChannelKind.ANALOG_IN;
		} else if ("B4455E98A0".equals(uid)) {
			setType(QUANTITY_MAGNETIC_FIELD);
			setName("Magnetic Field sensor");
			setUnit("mT");
			return ChannelKind.ANALOG_IN;
		} else if ("2A94216C69".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//7 Counter
			setName("Photogate");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("927A261423".equals(uid)) {
			setType(QUANTITY_TEMPERATURE);
			setName("Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("E74380D0F9".equals(uid)) {
			setType(QUANTITY_TEMPERATURE_WAND);
			setName("Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("71C24C7E31".equals(uid)) {
			setType(QUANTITY_PH);
			setName("pH sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("4450459E6D".equals(uid)) {
			setType(QUANTITY_VOLTAGE);
			setName("Voltage sensor (differential)");
			setUnit("V");
			return ChannelKind.ANALOG_IN;//Analog10
		} else if ("6F5880F2B4".equals(uid)) {
			setType(QUANTITY_CO2_GAS);
			setName("CO2 sensor");
			setUnit("ppm");
			return ChannelKind.ANALOG_IN;
		} else if ("1995385982".equals(uid)) {
			setType(QUANTITY_VOLTAGE);
			setName("Voltage sensor 30-V");
			setUnit("V");
			return ChannelKind.ANALOG_IN;//analog10
		} else if ("BDD8A50D73".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("3-Axis Accelerometer (Z)");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("0AF4523CDC".equals(uid)) {
			setType(QUANTITY_TEMPERATURE);
			setName("Thermocouple sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("EC497ECB83".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("ORP sensor");
			setUnit("mV");
			return ChannelKind.ANALOG_IN;
		} else if ("52598B2377".equals(uid)) {
			setType(QUANTITY_CURRENT);
			setName("Current sensor");
			setUnit("mA");
			return ChannelKind.ANALOG_IN;
		} else if ("4AEE0C407C".equals(uid)) {
			setType(QUANTITY_TEMPERATURE_WAND);
			setName("Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("4169FBDFF7".equals(uid)) {
			setType(QUANTITY_CO2_GAS);
			setName("CO2 sensor");
			setUnit("ppm");
			return ChannelKind.ANALOG_IN;
		} else if ("8B812444FE".equals(uid)) {
			setType(QUANTITY_WIND_SPEED);
			setName("Flow rate sensor");
			setUnit("m/s");
			return ChannelKind.ANALOG_IN;
		} else if ("BB7E6C2584".equals(uid)) {
			setType(QUANTITY_LIGHT);
			setName("Light Sensor with 3 ranges");
			setUnit("lx");
			return ChannelKind.ANALOG_IN;
		} else if ("C565E4".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("25-g Accelerometer");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("39F096BE62".equals(uid)) {
			setType(QUANTITY_HEART_RATE_SIGNAL);
			setName("Exercise Heart Rate sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("4B1054E687".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Nitrate sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("CFEBF46DE0".equals(uid)) {
			setType(QUANTITY_OXYGEN_GAS);
			setName("Oxygen sensor (gas)");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("40FFB94F45".equals(uid)) {
			setType(QUANTITY_DISTANCE);
			setName("Ultrasonic Motion Detector");
			setUnit("m");
			return ChannelKind.ANALOG_IN;
		} else if ("A758868E8F".equals(uid)) {
			setType(QUANTITY_TEMPERATURE);
			setName("Thermocouple sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("DC1901A69D".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//26 Switch
			setName("Reed switch sensor");
			setUnit("V");
			return ChannelKind.ANALOG_IN;
		} else if ("D1700B2409".equals(uid)) {
			setType(QUANTITY_HEART_RATE_SIGNAL);
			setName("Exercise Heart Rate sensor");
			setUnit("V");
			return ChannelKind.ANALOG_IN;
		} else if ("C6A6824ED7".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//22 Radiactivity
			setName("Geiger-M�ller sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("5C3FE823DB".equals(uid)) {
			setType(QUANTITY_DISTANCE);
			setName("Ultrasonic Motion Detector");
			setUnit("m");
			return ChannelKind.ANALOG_IN;//sonic??
		} else if ("8F1776B653".equals(uid)) {
			setType(QUANTITY_BLOOD_PRESSURE);
			setName("Blood Pressure sensor");
			setUnit("mmHg");
			return ChannelKind.ANALOG_IN;
		} else if ("EFB564BB37".equals(uid)) {
			setType(QUANTITY_TEMPERATURE);
			setName("Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("EEDFAFA57F".equals(uid)) {
			setType(QUANTITY_UVA_INTENSITY);
			setName("UVA sensor");
			setUnit("mW/m2");
			return ChannelKind.ANALOG_IN;
		} else if ("BE33B40669".equals(uid)) {
			setType(QUANTITY_GAS_PRESSURE);
			setName("Pressure sensor");
			setUnit("kPa");
			return ChannelKind.ANALOG_IN;
		} else if ("F82099F709".equals(uid)) {
			setType(QUANTITY_RELATIVE_HUMIDITY);
			setName("Humidity sensor");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("FA4DDAC3A0".equals(uid)) {
			setType(QUANTITY_FORCE);
			setName("Force sensor (Dual range)");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("2B1C8C6BF5".equals(uid)) {
			setType(QUANTITY_HEART_RATE_SIGNAL);
			setName("Hand-grip heart rate sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("2ABDE155E5".equals(uid)) {
			setType(QUANTITY_VOLTAGE);
			setName("Voltage sensor (differential)");
			setUnit("mV");
			return ChannelKind.ANALOG_IN;//Analog10
		} else if ("1E62D00733".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("3-Axis Accelerometer (X)");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("869A1572A6".equals(uid)) {
			setType(QUANTITY_TEMPERATURE_WAND);
			setName("Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("EA4F07403F".equals(uid)) {
			setType(QUANTITY_VOLTAGE);
			setName("Instrumentation amplifier");
			setUnit("V");
			return ChannelKind.ANALOG_IN;
		} else if ("F78AD3D439".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("3-Axis Accelerometer (X)");
			setUnit("g");
			return ChannelKind.ANALOG_IN;
		} else if ("D844C94281".equals(uid)) {
			setType(QUANTITY_UVA_INTENSITY);
			setName("UVA sensor");
			setUnit("mW/m2");
			return ChannelKind.ANALOG_IN;
		} else if ("2038A4AF9E".equals(uid)) {
			setType(QUANTITY_TEMPERATURE_WAND);
			setName("Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("5905162AF6".equals(uid)) {
			setType(QUANTITY_COLORIMETER);
			setName("Colorimeter 635nm");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("6696F00FFF".equals(uid)) {
			setType(QUANTITY_VOLTAGE);
			setName("-10 .. 10 V range");
			setUnit("V");
			return ChannelKind.ANALOG_IN;
		} else if ("1C169D910C".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("3-Axis Accelerometer (Y)");
			setUnit("g");
			return ChannelKind.ANALOG_IN;
		} else if ("1C64FE7F36".equals(uid)) {
			setType(QUANTITY_DISTANCE);
			setName("Ultrasonic Motion Detector");
			setUnit("m");
			return ChannelKind.ANALOG_IN;//sonic
		} else if ("BD912F7F38".equals(uid)) {
			setType(QUANTITY_CONDUCTIVITY);
			setName("Conductivity sensor");
			setUnit("µS");
			return ChannelKind.ANALOG_IN;
		} else if ("2A8B669B70".equals(uid)) {
			setType(QUANTITY_FORCE);
			setName("Force sensor (Dual range)");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("116857802E".equals(uid)) {
			setType(QUANTITY_VOLTAGE);
			setName("Voltmeter");
			setUnit("V");
			return ChannelKind.ANALOG_IN;
		} else if ("8A00C2929F".equals(uid)) {
			setType(QUANTITY_PULSE_RATE);
			setName("Heartbeat sensor");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("951A754722".equals(uid)) {
			setType(QUANTITY_SOUND_INTENSITY);
			setName("Sound level meter");
			setUnit("dB");
			return ChannelKind.ANALOG_IN;
		} else if ("FE6F775E8B".equals(uid)) {
			setType(QUANTITY_VOLTAGE);
			setName("Voltage sensor");
			setUnit("V");
			return ChannelKind.ANALOG_IN;
		} else if ("A8029D0463".equals(uid)) {
			setType(QUANTITY_CONDUCTIVITY);
			setName("Conductivity sensor");
			setUnit("µS/cm");
			return ChannelKind.ANALOG_IN;
		} else if ("1AC2B5A194".equals(uid)) {
			setType(QUANTITY_MAGNETIC_FIELD);
			setName("Magnetic Field sensor");
			setUnit("mT");
			return ChannelKind.ANALOG_IN;
		} else if ("FF01EA0001".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//26 Switch
			setName("Photogate");
			setUnit("s");
			return ChannelKind.ANALOG_IN;
		} else if ("7CB6384875".equals(uid)) {
			setType(QUANTITY_SOUND_INTENSITY);
			setName("Sound sensor");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("86FEE7BD0B".equals(uid)) {
			setType(QUANTITY_DISSOLVED_OXYGEN);
			setName("Dissolved Oxygen sensor");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("6186FF6AB6".equals(uid)) {
			setType(QUANTITY_LIGHT);
			setName("Light sensor");
			setUnit("lx");
			return ChannelKind.ANALOG_IN;
		} else if ("B785BB66E3".equals(uid)) {
			setType(QUANTITY_COLORIMETER);
			setName("Colorimeter 635nm");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("25CAE7F944".equals(uid)) {
			setType(QUANTITY_CONDUCTIVITY);
			setName("Conductivity sensor");
			setUnit("µS");
			return ChannelKind.ANALOG_IN;
		} else if ("4536ED7F00".equals(uid)) {
			setType(QUANTITY_VOLTAGE);
			setUnit("V");
			return ChannelKind.ANALOG_IN;
		} else if ("76B5FF05CE".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("3-Axis Accelerometer (X)");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("35B9BDEA1F".equals(uid)) {
			setType(QUANTITY_PH);
			setName("pH sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("2EAE55031E".equals(uid)) {
			setType(QUANTITY_LUNG_AIR_FLOW);
			setName("Spirometer");
			setUnit("L/s");
			return ChannelKind.ANALOG_IN;
		} else if ("281DAA8289".equals(uid)) {
			setType(27);
			setName("Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("0335CC401E".equals(uid)) {
			setType(QUANTITY_SOUND_INTENSITY);
			setName("Sound sensor");
			setUnit("Pa");
			return ChannelKind.ANALOG_IN;//analog10
		} else if ("A0697BF45E".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//28 turbidity
			setName("Turbidity sensor");
			setUnit("NTU");
			return ChannelKind.ANALOG_IN;
		} else if ("A033F73006".equals(uid)) {
			setType(QUANTITY_DISSOLVED_OXYGEN);
			setName("Dissolved Oxygen sensor");
			setUnit("mg/L");
			return ChannelKind.ANALOG_IN;
		} else if ("2A368A613C".equals(uid)) {
			setType(QUANTITY_FORCE);
			setName("Force plate");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("AD2723F2D0".equals(uid)) {
			setType(QUANTITY_VOLTAGE);
			setName("Voltage sensor (differential)");
			setUnit("V");
			return ChannelKind.ANALOG_IN;
		} else if ("7E2D60AF7D".equals(uid)) {
			setType(QUANTITY_PH);
			setName("pH sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("CCD2FC7888".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//22 Radiactivity
			setName("Radiation Monitor (digital)");
			setUnit("");
			return ChannelKind.DIGITAL_IN;
		} else if ("634E4C3F0B".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Charge sensor");
			setUnit("nC");
			return ChannelKind.ANALOG_IN;
		} else if ("428D499A06".equals(uid)) {
			setType(QUANTITY_CURRENT);
			setName("Current sensor");
			setUnit("mA");
			return ChannelKind.ANALOG_IN;//analog10
		} else if ("D85AE4A6C4".equals(uid)) {
			setType(QUANTITY_EKG);
			setName("EKG sensor");
			setUnit("mV");
			return ChannelKind.ANALOG_IN;
		} else if ("1469A6E179".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("3-Axis Accelerometer (Z)");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("D56F67F1A0".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Ammonium sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("31E76BAFF5".equals(uid)) {
			setType(QUANTITY_LUNG_AIR_FLOW);
			setName("Spirometer");
			setUnit("L/s");
			return ChannelKind.ANALOG_IN;
		} else if ("F44DAF9176".equals(uid)) {
			setType(QUANTITY_COLORIMETER);
			setName("Colorimeter 565nm");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("B825CE6524".equals(uid)) {
			setType(QUANTITY_EKG);
			setName("EKG sensor");
			setUnit("mV");
			return ChannelKind.ANALOG_IN;
		} else if ("7EFED2A45B".equals(uid)) {
			setType(QUANTITY_TEMPERATURE_WAND);
			setName("Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("C4C8446432".equals(uid)) {
			setType(QUANTITY_DISSOLVED_OXYGEN);
			setName("Dissolved Oxygen sensor");
			setUnit("mg/L");
			return ChannelKind.ANALOG_IN;
		} else if ("D794CA77F9".equals(uid)) {
			setType(QUANTITY_MAGNETIC_FIELD);
			setName("Magnetic Field sensor");
			setUnit("mT");
			return ChannelKind.ANALOG_IN;
		} else if ("FF90000005".equals(uid)) {
			setType(QUANTITY_WIND_SPEED);
			setName("Anemometer");
			setUnit("m/s");
			return ChannelKind.ANALOG_IN;
		} else if ("F48F4C434A".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("ORP sensor");
			setUnit("mV");
			return ChannelKind.ANALOG_IN;
		} else if ("D45A6645D7".equals(uid)) {
			setType(QUANTITY_CONDUCTIVITY);
			setName("Conductivity sensor");
			setUnit("µS");
			return ChannelKind.ANALOG_IN;
		} else if ("1E5C0E67E5".equals(uid)) {
			setType(QUANTITY_TEMPERATURE);
			setName("Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("0B802062FC".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//22 Radiactivity
			setName("Radiation sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("091C23EF70".equals(uid)) {
			setType(QUANTITY_RELATIVE_HUMIDITY);
			setName("Color Light R sensor");
			setUnit("R");
			return ChannelKind.ANALOG_IN;
		} else if ("45DA77BB0B".equals(uid)) {
			setType(27);
			setName("Surface Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("38DB8E80AB".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Charge sensor");
			setUnit("nC");
			return ChannelKind.ANALOG_IN;
		} else if ("BC246AA61F".equals(uid)) {
			setType(QUANTITY_LIGHT);
			setName("Light sensor");
			setUnit("klx");
			return ChannelKind.ANALOG_IN;
		} else if ("B8F8253901".equals(uid)) {
			setType(QUANTITY_SOUND_INTENSITY);
			setName("Sound sensor");
			setUnit("Pa");
			return ChannelKind.ANALOG_IN;
		} else if ("9BDA2C15E1".equals(uid)) {
			setType(QUANTITY_LIGHT);
			setName("Light Sensor with 3 ranges");
			setUnit("lx");
			return ChannelKind.ANALOG_IN;
		} else if ("8385A2FB6B".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//7 counter
			setName("Smart pulley");
			setUnit("");
			return ChannelKind.ANALOG_IN;//analog10
		} else if ("31964D192B".equals(uid)) {
			setType(QUANTITY_EKG);
			setName("EKG sensor");
			setUnit("mV");
			return ChannelKind.ANALOG_IN;
		} else if ("F2FC535B7E".equals(uid)) {
			setType(QUANTITY_TEMPERATURE_WAND);
			setName("Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("9227FBD6A5".equals(uid)) {
			setType(QUANTITY_CURRENT);
			setName("Current sensor");
			setUnit("A");
			return ChannelKind.ANALOG_IN;//analog10
		} else if ("69ABA2A25A".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//11 gas concentration
			setName("Ethanol sensor");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("E54A824E06".equals(uid)) {
			setType(QUANTITY_CURRENT);
			setName("Current sensor");
			setUnit("mA");
			return ChannelKind.ANALOG_IN;
		} else if ("C228F086AB".equals(uid)) {
			setType(QUANTITY_SALINITY);
			setName("Salinity sensor");
			setUnit("ppt");
			return ChannelKind.ANALOG_IN;
		} else if ("93580A75CF".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//7 Counter
			setName("Photogate");
			setUnit("V");
			return ChannelKind.DIGITAL_IN;
		} else if ("EFCB3716F4".equals(uid)) {
			setType(QUANTITY_FORCE);
			setName("Force plate");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("8E6A16E035".equals(uid)) {
			setType(QUANTITY_MAGNETIC_FIELD);
			setName("Magnetic Field sensor");
			setUnit("mT");
			return ChannelKind.ANALOG_IN;
		} else if ("20FADA310C".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("ORP sensor");
			setUnit("mV");
			return ChannelKind.ANALOG_IN;
		} else if ("EC6B862E38".equals(uid)) {
			setType(QUANTITY_MAGNETIC_FIELD);
			setName("Magnetic Field sensor");
			setUnit("G");
			return ChannelKind.ANALOG_IN;
		} else if ("2D8E5FA78A".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Charge sensor");
			setUnit("nC");
			return ChannelKind.ANALOG_IN;
		} else if ("0C425D5BC5".equals(uid)) {
			setType(QUANTITY_MAGNETIC_FIELD);
			setName("Magnetic Field sensor");
			setUnit("mT");
			return ChannelKind.ANALOG_IN;
		} else if ("DCA195C514".equals(uid)) {
			setType(QUANTITY_DISTANCE);
			setName("Altimeter");
			setUnit("m");
			return ChannelKind.ANALOG_IN;
		} else if ("D123D72376".equals(uid)) {
			setType(QUANTITY_BLOOD_PRESSURE);
			setName("Blood Pressure sensor");
			setUnit("mmHg");
			return ChannelKind.ANALOG_IN;
		} else if ("E88F5FFBB3".equals(uid)) {
			setType(QUANTITY_CONDUCTIVITY);
			setName("Conductivity sensor");
			setUnit("µS");
			return ChannelKind.ANALOG_IN;
		} else if ("80935A8EC7".equals(uid)) {
			setType(QUANTITY_VOLTAGE);
			setName("Voltage sensor");
			setUnit("V");
			return ChannelKind.ANALOG_IN;//analog10
		} else if ("7DFB5E1C32".equals(uid)) {
			setType(QUANTITY_GAS_PRESSURE);
			setName("Barometer");
			setUnit("hPa");
			return ChannelKind.ANALOG_IN;
		} else if ("6A50C6DD6F".equals(uid)) {
			setType(QUANTITY_TEMPERATURE);
			setName("Thermocouple sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("05936CA1FD".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("High g Accelerometer");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("0A2956A3FD".equals(uid)) {
			setType(QUANTITY_GAS_PRESSURE);
			setName("Pressure sensor");
			setUnit("kPa");
			return ChannelKind.ANALOG_IN;
		} else if ("D51F1A76B5".equals(uid)) {
			setType(QUANTITY_COLORIMETER);
			setName("Colorimeter 565nm");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("8256AF21A7".equals(uid)) {
			setType(QUANTITY_FORCE);
			setName("Force sensor (Dual range)");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("D92AF99692".equals(uid)) {
			setType(QUANTITY_ANGULAR_VELOCITY);//QUANTITY_COMPASS?
			setName("Angle position sensor");
			setUnit("°");
			return ChannelKind.ANALOG_IN;
		} else if ("3AAE759C2B".equals(uid)) {
			setType(QUANTITY_LIGHT);
			setName("Light sensor");
			setUnit("lx");
			return ChannelKind.ANALOG_IN;
		} else if ("242DE795DA".equals(uid)) {
			setType(QUANTITY_COLORIMETER);
			setName("Colorimeter 470nm");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("F2742CA5E2".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Charge sensor");
			setUnit("nC");
			return ChannelKind.ANALOG_IN;
		} else if ("0CEA4195A7".equals(uid)) {
			setType(QUANTITY_FORCE);
			setName("Force plate");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("B0B64A87EA".equals(uid)) {
			setType(QUANTITY_HEART_RATE_SIGNAL);
			setName("Exercise Heart Rate sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("0767568C00".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//22 Radiactivity
			setName("Radiation sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("8F1B97CD3C".equals(uid)) {
			setType(QUANTITY_GAS_PRESSURE);
			setName("Baro sensor");
			setUnit("mbar");
			return ChannelKind.ANALOG_IN;
		} else if ("B858D579E1".equals(uid)) {
			setType(QUANTITY_CURRENT);
			setName("Current sensor");
			setUnit("A");
			return ChannelKind.ANALOG_IN;//analog10
		} else if ("9D19E354BD".equals(uid)) {
			setType(QUANTITY_FORCE);
			setName("Force sensor (Dual range)");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("1B3EB188F4".equals(uid)) {
			setType(QUANTITY_OXYGEN_GAS);
			setName("Oxygen sensor (gas)");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("15F5AF9307".equals(uid)) {
			setType(QUANTITY_CONDUCTIVITY);
			setName("Conductivity sensor");
			setUnit("µS");
			return ChannelKind.ANALOG_IN;
		} else if ("0E1C49446B".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("3-Axis Accelerometer (X)");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("6DBF16674D".equals(uid)) {
			setType(QUANTITY_CURRENT);
			setName("Current sensor");
			setUnit("A");
			return ChannelKind.ANALOG_IN;
		} else if ("FDD2A657B1".equals(uid)) {
			setType(QUANTITY_PH);
			setName("pH sensor");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("80FA4251E3".equals(uid)) {
			setType(QUANTITY_ACCELERATION);
			setName("3-Axis Accelerometer (Y)");
			setUnit("m/s2");
			return ChannelKind.ANALOG_IN;
		} else if ("95011BBFB8".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//7 Counter
			setName("Smart pulley");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("4AFF90480C".equals(uid)) {
			setType(QUANTITY_CURRENT);
			setName("Current sensor");
			setUnit("mA");
			return ChannelKind.ANALOG_IN;
		} else if ("9F528D71B8".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//22 Radiactivity
			setName("Radiation sensor");
			setUnit("cpm");
			return ChannelKind.ANALOG_IN;
		} else if ("E7F8B7A2C8".equals(uid)) {
			setType(QUANTITY_HAND_DYNAMOMETER);
			setName("Hand dynamometer");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("712BA90613".equals(uid)) {
			setType(QUANTITY_CO2_GAS);
			setName("CO2 sensor");
			setUnit("ppm");
			return ChannelKind.ANALOG_IN;
		} else if ("AC931C7DF1".equals(uid)) {
			setType(QUANTITY_ANGULAR_VELOCITY);//QUANTITY_COMPASS?
			setName("Angle position sensor");
			setUnit("°");
			return ChannelKind.ANALOG_IN;
		} else if ("538306E5C7".equals(uid)) {
			setType(QUANTITY_CONDUCTIVITY);
			setName("Conductivity sensor");
			setUnit("µS");
			return ChannelKind.ANALOG_IN;
		} else if ("7AA2DFEC96".equals(uid)) {
			setType(QUANTITY_LIGHT);
			setName("Light sensor");
			setUnit("lx");
			return ChannelKind.ANALOG_IN;
		} else if ("E0AFA01AB0".equals(uid)) {
			setType(QUANTITY_OXYGEN_GAS);
			setName("Oxygen sensor (gas)");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("206EAADCB8".equals(uid)) {
			setType(QUANTITY_LIGHT);
			setName("Light sensor");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("1168578FFF".equals(uid)) {
			setType(29);
			setName("0 .. 5 V range");
			setUnit("V");
			return ChannelKind.ANALOG_IN;
		} else if ("55F1EEC0F7".equals(uid)) {
			setType(QUANTITY_DISTANCE);
			setName("Ultrasonic Motion Detector");
			setUnit("m");
			return ChannelKind.ANALOG_IN;//sonic
		} else if ("F7D2771C96".equals(uid)) {
			setType(27);
			setName("Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("7DAF767440".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Charge sensor");
			setUnit("nC");
			return ChannelKind.ANALOG_IN;
		} else if ("48DB66A59F".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//22 Radiactivity
			setName("Radiation Monitor / Student (digital)");
			setUnit("");
			return ChannelKind.DIGITAL_IN;
		} else if ("FF84000000".equals(uid)) {
			setType(QUANTITY_EKG);
			setName("EKG sensor");
			setUnit("mV");
			return ChannelKind.ANALOG_IN;
		} else if ("FB3B297883".equals(uid)) {
			setType(QUANTITY_FORCE);
			setName("Force sensor (Dual range)");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("1E968A5868".equals(uid)) {
			setType(QUANTITY_UNKNOWN);//15 ion
			setName("Charge sensor");
			setUnit("nC");
			return ChannelKind.ANALOG_IN;
		} else if ("E8B930BF36".equals(uid)) {
			setType(QUANTITY_SALINITY);
			setName("Salinity sensor");
			setUnit("ppt");
			return ChannelKind.ANALOG_IN;
		} else if ("CB13C352A7".equals(uid)) {
			setType(QUANTITY_FORCE);
			setName("Force plate");
			setUnit("N");
			return ChannelKind.ANALOG_IN;
		} else if ("8483F72A06".equals(uid)) {
			setType(QUANTITY_DISSOLVED_OXYGEN);
			setName("Dissolved Oxygen sensor");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("6696F00ADF".equals(uid)) {
			setType(QUANTITY_VOLTAGE);
			setName("Voltmeter");
			setUnit("V");
			return ChannelKind.ANALOG_IN;//analog10
		} else if ("221AEC024B".equals(uid)) {
			setType(QUANTITY_SALINITY);
			setName("Gas Pressure sensor");
			setUnit("bar");
			return ChannelKind.ANALOG_IN;
		} else if ("0E6265FE81".equals(uid)) {
			setType(QUANTITY_CURRENT);
			setName("Current sensor");
			setUnit("mA");
			return ChannelKind.ANALOG_IN;
		} else if ("2F008BE35C".equals(uid)) {
			setType(QUANTITY_TEMPERATURE);
			setName("Thermocouple sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("B95AE038C5".equals(uid)) {
			setType(QUANTITY_OXYGEN_GAS);
			setName("Oxygen sensor (gas)");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("45ED1C7AB6".equals(uid)) {
			setType(QUANTITY_RELATIVE_HUMIDITY);
			setName("Humidity sensor");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("22A881D8BD".equals(uid)) {
			setType(QUANTITY_CONDUCTIVITY);
			setName("Conductivity sensor");
			setUnit("µS");
			return ChannelKind.ANALOG_IN;
		} else if ("98154AEFF6".equals(uid)) {
			setType(QUANTITY_CONDUCTIVITY);
			setName("Conductivity sensor");
			setUnit("µS");
			return ChannelKind.ANALOG_IN;
		} else if ("EBD450FCB0".equals(uid)) {
			setType(QUANTITY_GAS_PRESSURE);
			setName("Pressure sensor");
			setUnit("kPa");
			return ChannelKind.ANALOG_IN;
		} else if ("25149C34A3".equals(uid)) {
			setType(QUANTITY_COLORIMETER);
			setName("Colorimeter (4 colors)");
			setUnit("");
			return ChannelKind.ANALOG_IN;
		} else if ("D276598A0E".equals(uid)) {
			setType(QUANTITY_SALINITY);
			setName("Gas Pressure sensor");
			setUnit("kPa");
			return ChannelKind.ANALOG_IN;
		} else if ("B7D57D7F55".equals(uid)) {
			setType(QUANTITY_RELATIVE_HUMIDITY);
			setName("Humidity sensor");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("B16B1F4C02".equals(uid)) {
			setType(QUANTITY_TEMPERATURE_WAND);
			setName("Temperature sensor");
			setUnit("°C");
			return ChannelKind.ANALOG_IN;
		} else if ("126E69DACC".equals(uid)) {
			setType(QUANTITY_MAGNETIC_FIELD);
			setName("Magnetic Field sensor");
			setUnit("mT");
			return ChannelKind.ANALOG_IN;
		} else if ("A56065F058".equals(uid)) {
			setType(QUANTITY_SOUND_INTENSITY);
			setName("Sound sensor");
			setUnit("Pa");
			return ChannelKind.ANALOG_IN;//analog10
		} else if ("0EC075E0D9".equals(uid)) {
			setType(QUANTITY_PULSE_RATE);
			setName("Heartbeat sensor");
			setUnit("%");
			return ChannelKind.ANALOG_IN;
		} else if ("78E4AEB47C".equals(uid)) {
			setType(QUANTITY_CO2_GAS);
			setName("CO2 sensor");
			setUnit("ppm");
			return ChannelKind.ANALOG_IN;
		} else if ("9964B3020C".equals(uid)) {
			setType(QUANTITY_DISTANCE);
			setName("Ultrasonic Motion Detector");
			setUnit("m");
			return ChannelKind.ANALOG_IN;//sonic
		} else if ("EEC251773D".equals(uid)) {
			setType(QUANTITY_CURRENT);
			setName("Current sensor");
			setUnit("mA");
			return ChannelKind.ANALOG_IN;
		} else if ("8AFD79072B".equals(uid)) {
			setType(QUANTITY_LUNG_AIR_FLOW);
			setName("Spirometer");
			setUnit("L/s");
			return ChannelKind.ANALOG_IN;
		} else {
			setType(QUANTITY_UNKNOWN);
		}
	
		 return ChannelKind.NONE;

		}



}
