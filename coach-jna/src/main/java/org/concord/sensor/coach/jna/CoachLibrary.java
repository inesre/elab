package org.concord.sensor.coach.jna;


import java.io.File;
import java.io.IOException;


import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;

public class CoachLibrary extends LibraryBase{

	
	private static CoachLibrary instance;
	private CoachJNA jnaLib;

	private String deviceName;
	
	private File directory;
	private Info info;

	
	public void initLibrary(String deviceName1, String directory) throws IOException, InterruptedException{
		if(jnaLib != null){
			return;
		}	
		this.directory = new File(directory);
	    deviceName=deviceName1;

	    File nativeLibFile = getNativeLibraryFromJar();
		String nativeLibPath = nativeLibFile.getAbsolutePath();


		jnaLib = (CoachJNA) Native.loadLibrary(nativeLibPath, CoachJNA.class);
		NativeHelper.deleteNativeLibrary(nativeLibFile);
		info = new Info();
		jnaLib.GetInfo(info.getAnalogIn(), info.getAnalogOut(), info.getDigitalIn(), info.getDigitalOut(), info.getCounter(), info.getStepCounter());
		NativeHelper.deleteNativeLibrary(nativeLibFile);
	}
	
	
	public static CoachLibrary getInstance() {
		if(instance != null){
			return instance;
		}
		instance = new CoachLibrary();
		return instance;
	}
	
	

	
	public String getDeviceName(){
		return deviceName;
	}
	   
	@Override
	protected File getNativeLibraryFromJar() throws IOException, InterruptedException {
    	if ("CrossRoadsOrCoachLab".equals(deviceName)) {
		} else if ("CoachLabIIPlus".equals(deviceName)) {
		} else if ("CoachLabIIPlusPlus".equals(deviceName)) {
		} else if ("ELab".equals(deviceName)) {
			if(directory==null) createTmpDirectory();
			if(Platform.isWindows()){
	              extractResource("c7lib.xml",directory);
	              extractResource("coachlib.xml",directory);
	              extractResource("hidapi.dll",directory);
	              extractResource("Lafread.dll",directory);
	              extractResource("borlndmm.dll",directory);
	              extractResource("lib-en.laf",directory);
	              extractResource("libusb-1.0.dll",directory);
	              extractResource("libusb0.dll",directory);
	              extractResource("SerCom.dll",directory);
	              extractResource("UsbCom.dll",directory);
	              
	              return extractResource("elab.dll", directory);
	      	} else if (Platform.isMac()){
	      		extractResource("liblafread.dylib",directory);
	      		extractResource("libhid.dylib",directory);
	      		return extractResource("libelab.dylib", directory);
	      	}
		} else if ("ESense".equals(deviceName)) {
		} else if ("ULab".equals(deviceName)) {
		} else if ("CLab".equals(deviceName)) {
		} else if ("ELabII".equals(deviceName)) {
		} else if ("SilverLink".equals(deviceName)) {
		} else if ("EuroMotion".equals(deviceName)) {
		} else if ("MoLab".equals(deviceName)) {
		} else if ("NXT".equals(deviceName)) {
		} else if ("LEGOUSBTower".equals(deviceName)) {
		} else if ("LabPro".equals(deviceName)) {
		} else if ("VinciLab".equals(deviceName)) {
		} else if ("Adam Balance".equals(deviceName)) {
		}
    	
    	return null;
    	

    }
	

    

    
	public void initialize(){
		Memory mTest = new Memory((directory.getAbsolutePath()).length()+1);
		mTest.setString(0, directory.getAbsolutePath());
	    jnaLib.Initialise(mTest);
	    
	    
	} 
        
    
    
	public void stopMeasurement(){
		jnaLib.AbortMeasurement(null);
	}

	

	 public byte connect(byte chkind, short num, boolean isDetected,boolean isCurrect, boolean IgnoreCalibration, String uid){
		 if(uid ==null) uid = "";
		 Memory mUID = new Memory(uid.length()+1);
	     mUID.setString(0, uid);
   
		return jnaLib.ConnectedEx4(chkind, num, isDetected, isCurrect, IgnoreCalibration, mUID);
	
	 }
	    
	
	 

	 

	

    public float maxPoints(){
    	return jnaLib.MaxPoints(null);
    }
	
	//Measurement
	
	//Channel
    public String detectSensor(short ch) {
		
	
		
			String[] uid = new String[1];
			if((jnaLib.DetectEx(ch, uid))!=-2) {
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
					
				}
				if((jnaLib.DetectEx(ch, uid))!=-2) {
					
					return null;
				}
				
			}return null;

	}
    
    
    
    //info
    public Info getInfo(){
    	return this.info;
    }
    
    
    public int getNumberMeasurement(){
    	return jnaLib.Number_Of_MeasuredEx(null);
    }
    

	
	

	

    
	
	

	
    public void startMeasurement(float freq, int durationInMS, short channels, short outChannels, short inDigi, short outDigi, short counts, short StepCounts){
    	jnaLib.StartMeasurement(freq, durationInMS, channels, outChannels, inDigi, outDigi, counts, StepCounts);
    }
    
    public boolean measuringIsRunning(){
    	return jnaLib.MeasuringIsRunning(null);
    }
    
    public float getMeasurementEx(int index, byte ch){
    	return jnaLib.GetMeasurementEx(index, ch);
    }


	public void close() {
		
		
		jnaLib.CloseDLL(null);
		jnaLib.FreeMeasurements(null);
		//System.out.println("isClosedDLL "+jnaLib.IsClosedDLL(null));
	//	deleteDirectory(directory);
		//System.out.println(directory.getAbsolutePath());
		
	}


	public void disconnectChannel(byte channelKind, byte channel) {
		jnaLib.Disconnected(channelKind, (short) channel);
		
	}

	
	
	
	
	
	
}
