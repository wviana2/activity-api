package com.fmv.reg.misc.service;

import com.fmv.reg.misc.entity.Activity;
import com.fmv.reg.misc.model.ActivityResponseWrapper;

public interface ActivityService {

	<T> ActivityResponseWrapper<T> getAllActivities() throws Exception;
	
	<T> ActivityResponseWrapper<T> addActivity(Activity activity) throws Exception;
	
	<T> ActivityResponseWrapper<T> markActivity(Activity activity) throws Exception;
	
	<T> ActivityResponseWrapper<T> removeActivity(Activity activity) throws Exception;
}
