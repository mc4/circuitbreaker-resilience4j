package com.optimism.circuitbreaker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.optimism.circuitbreaker.model.Activity;
import com.optimism.circuitbreaker.service.ActivityService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/activity")
public class ActivityController {

	private RestTemplate restTemplate;
	private ActivityService activityService;

	@Value("${bored.api}")
	private String BORED_API;

	public ActivityController(final RestTemplate restTemplate, final ActivityService activityService) {
		this.restTemplate = restTemplate;
		this.activityService = activityService;
	}

	@GetMapping
	@ExceptionHandler({ HttpClientErrorException.TooManyRequests.class })
	@CircuitBreaker(name = "randomActivity", fallbackMethod = "fallback")
	public String getRandomActivity() {
		final ResponseEntity<Activity> responseEntity = restTemplate.getForEntity(BORED_API, Activity.class);
		final Activity activity = responseEntity.getBody();
		activityService.saveActivity(activity);
		log.info("Activity: " + activity.toString());
		return activity.getActivity();
	}

	public String fallback(final Throwable throwable) {
		log.info("Fall back for too many requests... msg=" + throwable.toString());
		return "Fall back for too many requests";
	}

}
