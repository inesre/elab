package org.concord.sensor.coach.jna;

import com.sun.jna.Library;
import com.sun.jna.Pointer;

public interface CoachHelperJNA extends Library{

	
	/**
	 * Detect cma devices
	 * @param info InfoMemory
	 * @param max_dev maximum number of devices
	 * @return number of detected devices
	 */
	public Integer get_cma_detected_types(Pointer info, Integer max_dev);
}
