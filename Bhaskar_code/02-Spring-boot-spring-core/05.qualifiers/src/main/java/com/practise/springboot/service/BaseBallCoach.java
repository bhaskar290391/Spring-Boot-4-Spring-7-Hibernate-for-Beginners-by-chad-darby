package com.practise.springboot.service;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practise Batting for 1 hrs";
	}

}
