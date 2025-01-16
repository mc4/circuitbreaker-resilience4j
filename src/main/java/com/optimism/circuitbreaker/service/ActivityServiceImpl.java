package com.optimism.circuitbreaker.service;

import org.springframework.stereotype.Service;

import com.optimism.circuitbreaker.model.Activity;
import com.optimism.circuitbreaker.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService {

	private ActivityRepository activityRepository;

	public ActivityServiceImpl(final ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}

	@Override
	public Activity saveActivity(final Activity activity) {
		return activityRepository.save(activity);
	}

}
