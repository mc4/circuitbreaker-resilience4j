package com.optimism.circuitbreaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optimism.circuitbreaker.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
