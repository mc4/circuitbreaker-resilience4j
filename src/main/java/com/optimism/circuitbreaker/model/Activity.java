package com.optimism.circuitbreaker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Activity {
	private String activity;
	private Double availability;
	private String type;
	private Integer participants;
	private Double price;
	private String accessibility;
	private String duration;
	private Boolean kidFriendly;
	private String link;
	private String key;
}
