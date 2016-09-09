package org.concord.sensor.coach.jna;
/**
 * This class contains the information about a detected device
 */
public class DeviceInfo {

	private int productID;
	private int deviceID;
	private int release;
	private String deviceType;
	
	public DeviceInfo(int productID, int deviceID, int release){
		this.productID = productID;
		this.deviceID = deviceID;
		this.release = release;
		this.deviceType = this.type(deviceID,productID);
	}
	
	
	private String type(int deviceID, int productID) {
		switch (deviceID) {
		case 0x1126://1126
			if(productID == 0x0001) return "CrossRoadsOrCoachLab";//0001
			if(productID == 0x0102) return "CoachLabIIPlus";//0102
			if(productID == 0x0103) return "CoachLabIIPlusPlus";//0103
			if(productID == 0x0002) return "ELab";//0002
			if(productID == 0x0003) return "ESense";//0003
			if(productID == 0x0100) return "ULab";//0100
			if(productID == 0x0130) return "CLab";//0130
			if(productID == 0x0004) return "ELabII";//0004
			break;
		case 0x0451://0451
			if(productID == 0xE001) return "SilverLink";//E001
			break;
		case 0x0547://0547
			if(productID == 0x1003) return "EuroMotion";//1003
			if(productID == 0x2720) return "MoLab";//2720
			break;
		case 0x0694://0694
			if(productID == 0x0002) return "NXT";//0002
			if(productID == 0x0001) return "LEGOUSBTower";//0001
			break;
		case 0X08F7://08F7
			if(productID == 0x0001) return "LabPro";//0001
			break;
		case 0X0525://0525
			if(productID == 0xa4a2) return "VinciLab";//a4a2
			break;
		case 0X0403://0403
			if(productID == 0x6001) return "Adam Balance";//6001
			break;
		case 0x04D8://04D8
			if(productID == 0x0015) return "WAC";
		}
		
		return "none";
	}

	public int getProductID(){
		return productID;
	}
	
	public int getDeviceID(){
		return deviceID;
	}
	public int getRelease(){
		return release;
	}
	
	public String getDeviceType(){
		return this.deviceType;
	}
}
