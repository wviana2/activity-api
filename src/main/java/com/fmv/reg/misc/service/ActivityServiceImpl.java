package com.fmv.reg.misc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmv.reg.misc.constants.AppConstants;
import com.fmv.reg.misc.entity.Activity;
import com.fmv.reg.misc.model.ActivityResponseWrapper;
import com.fmv.reg.misc.repository.ActivityRepository;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityRepository activityRepo;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T> ActivityResponseWrapper<T> getAllActivities() throws Exception {
		List<Activity> activityList = activityRepo.findAll(Sort.by(Sort.Direction.ASC, "activityId"));	
		return wrapResponse(activityList, AppConstants.Status.SUCCESS.value, AppConstants.Message.SEARCH_SUCCESS_MESSAGE.value);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T> ActivityResponseWrapper<T> addActivity(Activity activity) throws Exception {
		Activity act = activityRepo.save(activity);
		return wrapResponse(act, AppConstants.Status.SUCCESS.value, AppConstants.Message.ADD_SUCCESS_MESSAGE.value);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T> ActivityResponseWrapper<T> markActivity(Activity activity) throws Exception {
		Optional<Activity> activityOpt = activityRepo.findById(activity.getActivityId());
		Activity updActivity = null;
		
		if(activityOpt.isPresent()) {
			updActivity = activityOpt.get();
			updActivity.setComplete(activity.isComplete());
			updActivity = activityRepo.save(updActivity);
		}
		return wrapResponse(updActivity, AppConstants.Status.SUCCESS.value, AppConstants.Message.UPDATE_SUCCESS_MESSAGE.value);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T> ActivityResponseWrapper<T> removeActivity(Activity activity) throws Exception {
		boolean result = false;
		Optional<Activity> activityOpt = activityRepo.findById(activity.getActivityId());
		Activity updActivity = null;
		
		if(activityOpt.isPresent()) {
			updActivity = activityOpt.get();
			activityRepo.delete(updActivity);
			result = true;
		}
		return wrapResponse(result, AppConstants.Status.SUCCESS.value, AppConstants.Message.DELETE_SUCCESS_MESSAGE.value);
	}
	
	private <T> ActivityResponseWrapper wrapResponse(T data, String status, String message) {
		ActivityResponseWrapper<T> wrapper = new ActivityResponseWrapper<>();
		wrapper.setData(data);
		wrapper.setStatus(status);
		wrapper.setMessage(message);
		
		return wrapper;
	}

}
