package com.practise.springboot.service;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkout() {

		return "Practise Fast bowling for 1 hrs";
	}

}
