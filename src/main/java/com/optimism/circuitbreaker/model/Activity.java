package com.optimism.circuitbreaker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long activityId;
	private String activity;
	private Double availability;
	private String activityType;
	private Integer participants;
	private Double price;
	private String accessibility;
	private String duration;
	private Boolean kidFriendly;
	private String link;
	private String activityKey;
}
