package com.optimism.circuitbreaker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.optimism.circuitbreaker.model.Activity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/activity")
public class ActivityController {

	private RestTemplate restTemplate;

	@Value("${bored.api}")
	private String BORED_API;

	public ActivityController(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping
	public String getRandomActivity() {
		final ResponseEntity<Activity> responseEntity = restTemplate.getForEntity(BORED_API, Activity.class);
		final Activity activity = responseEntity.getBody();
		log.info("Activity: " + activity.toString());
		return activity.getActivity();
	}

}
