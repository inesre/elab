package org.concord.sensor.coach.jna;

import com.sun.jna.Library;
import com.sun.jna.Pointer;


/**
 * General interface for comunicating with the different libraries of the cma devices
 *
 */
public interface CoachJNA extends Library {
	
	

	
	
	//Initialise
    public int Initialise(Pointer pStr);
    
    //Detection  
    //Windows
    public Short DetectEx(Short ch, String[] uid);

    
    
    //Connection
    //Windows
    public Byte ConnectedEx4(Byte chkind, Short num, Boolean isDetected,Boolean isCurrect, Boolean IgnoreCalibration, Pointer pStr);

    
    //Info
    public Void GetInfo(byte[] anali,byte[] analo, byte[] digi, byte[] digo, byte[] counter, byte[] stepcounter);
   
    public float MaxPoints(Void dummy);
   
    //Measurement
    public Void StartMeasurement(float freq, Integer durationInMS, Short channels, Short outChannels, Short inDigi, Short outDigi, Short counts, Short StepCounts);
    public boolean MeasuringIsRunning(Void dummy);
    public float GetMeasurementEx(Integer index, Byte ch);
  

    //Info during measurement
    public int Number_Of_MeasuredEx(Void v);

    
    //Another functions (for next machines)
    public Void AbortMeasurement(Void v);
    public Void FreeMeasurements(Void v);

                
    

    public Boolean CanCloseDLL(Void v);
    public Void Disconnected(Byte chkind, Short num);

    
    
    //Close
    public Void CloseDLL(Void dummy);
    public boolean IsClosedDLL(Void dummy);
    
   
}
