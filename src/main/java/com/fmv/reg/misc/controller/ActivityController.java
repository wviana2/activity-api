package com.fmv.reg.misc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmv.reg.misc.constants.AppConstants;
import com.fmv.reg.misc.entity.Activity;
import com.fmv.reg.misc.model.ActivityResponseWrapper;
import com.fmv.reg.misc.service.ActivityService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ActivityController {

	private static final Logger logger = LogManager.getLogger(ActivityController.class);

	@Autowired
	private ActivityService activityService;

	@GetMapping("/activities")
	public <T> ResponseEntity<ActivityResponseWrapper<T>> getActivities() {
		logger.info("getActivities() invoked!");
		ActivityResponseWrapper<T> wrapper = null;
		try {
			wrapper = activityService.getAllActivities();
			return ResponseEntity.ok(wrapper);
		} catch (Exception e) {
			logger.error("Exception thrown while invoking getAllActivities().  Error message: {}", e.getMessage(), e);
			wrapper = new ActivityResponseWrapper<T>();
			wrapper.setStatus(AppConstants.Status.ERROR.value);
			wrapper.setMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(wrapper);
		}
	}

	@PostMapping("/addactivity")
	public <T> ResponseEntity<ActivityResponseWrapper<T>> addActivity(@RequestBody Activity activity) {
		logger.info("addActivity(): {}", activity);
		ActivityResponseWrapper<T> wrapper = null;

		try {
			wrapper = activityService.addActivity(activity);
			return ResponseEntity.ok(wrapper);
		} catch (Exception e) {
			logger.error("Exception thrown while invoking addActivity().  Error message: {}", e.getMessage(), e);
			wrapper = new ActivityResponseWrapper<T>();
			wrapper.setStatus(AppConstants.Status.ERROR.value);
			wrapper.setMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(wrapper);
		}
	}

	@PostMapping("/markactivity")
	public <T> ResponseEntity<ActivityResponseWrapper<T>> markActivity(@RequestBody Activity activity) {
		logger.info("markActivity(): {}", activity);
		ActivityResponseWrapper<T> wrapper = null;

		try {
			wrapper = activityService.markActivity(activity);
			return ResponseEntity.ok(wrapper);
		} catch (Exception e) {
			logger.error("Exception thrown while invoking markActivity().  Error message: {}", e.getMessage(), e);
			wrapper = new ActivityResponseWrapper<T>();
			wrapper.setStatus(AppConstants.Status.ERROR.value);
			wrapper.setMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(wrapper);
		}
	}

	@PostMapping("/removeactivity")
	public <T> ResponseEntity<ActivityResponseWrapper<T>> removeActivity(@RequestBody Activity activity) {
		logger.info("removeActivity(): {}", activity);
		ActivityResponseWrapper<T> wrapper = null;
		try {
			wrapper = activityService.removeActivity(activity);
			return ResponseEntity.ok(wrapper);
		} catch (Exception e) {
			logger.error("Exception thrown while invoking markActivity().  Error message: {}", e.getMessage(), e);
			wrapper = new ActivityResponseWrapper<T>();
			wrapper.setStatus(AppConstants.Status.ERROR.value);
			wrapper.setMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(wrapper);
		}
	}
}
