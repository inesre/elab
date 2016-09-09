package org.concord.sensor.coach.jna;

import java.io.File;
import java.io.IOException;


import com.sun.jna.Native;
import com.sun.jna.Platform;
/**
 * 
 * @see CoachLibrary
 *
 */
public class CoachHelperLibrary extends LibraryBase {

	private CoachHelperJNA jnaLibHelper;

	private File directory;

	private static CoachHelperLibrary instance;

	public String getDirectory(){
		return directory.getAbsolutePath(); 
	}
	
	
	private CoachHelperLibrary() throws IOException, InterruptedException{
		NativeHelper.removeTemporaryFiles();
		File nativeLibFile = getNativeLibraryFromJar();
		String nativeLibPath = nativeLibFile.getAbsolutePath();	
	    jnaLibHelper = (CoachHelperJNA) Native.loadLibrary(nativeLibPath, 
				CoachHelperJNA.class);
		NativeHelper.deleteNativeLibrary(nativeLibFile);
	    
	}
	
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public DeviceInfo[] detectDevices(int max_devices){
		if(max_devices<=0) return null;

	
	    
		MemoryInfo mTest = new MemoryInfo(max_devices);
		mTest.setString(0, "");

	    int numDevices = jnaLibHelper.get_cma_detected_types(mTest, max_devices);
	  //  NativeHelper.deleteNativeLibrary(nativeLibFile);
	    return mTest.getDeviceInfo(numDevices);
	    
		
		
	}
	/**
	 * Detects connected devices
	 * @return DeviceInfo[]
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws CoachException 
	 */
	public DeviceInfo[] detectAllDevices() throws IOException, InterruptedException, CoachException{
		DeviceInfo[] devices= this.detectDevices(6);
		if (devices==null || devices.length==0) 
			throw new CoachException("No devices found.");	

		return devices;
	}

	/**
	 * Detects only one connected device
	 * @return DeviceInfo
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws CoachException 
	 */
	public DeviceInfo detectFirstDevice() throws IOException, InterruptedException, CoachException{
		DeviceInfo[] devices= this.detectDevices(1);
	
		if (devices==null || devices.length==0) 
			throw new CoachException("No devices found.");	

		
		return devices[0];
	    		
	}
	
	
    protected File getNativeLibraryFromJar() throws IOException, InterruptedException {
    	if(Platform.isWindows()){
            directory = createTmpDirectory();
          
            extractResource("fpcmemdll.dll",directory);
            return extractResource("helper.dll", directory);
    	} else if (Platform.isMac()){
    		 directory = createTmpDirectory();
    		
    		return extractResource("libhelper.dylib", directory);
    	} else {
    		return null;
    	}
    }
	
	
   
    
	
	public static CoachHelperLibrary getInstance() throws IOException, InterruptedException {
		if(instance != null){
			return instance;
		}
		instance = new CoachHelperLibrary();
		return instance;
	}
	
	
	

}
