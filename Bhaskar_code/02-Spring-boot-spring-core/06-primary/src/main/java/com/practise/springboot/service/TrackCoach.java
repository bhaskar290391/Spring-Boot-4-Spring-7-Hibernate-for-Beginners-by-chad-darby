package com.practise.springboot.service;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		
		return "Runnning hard 5 km";
	}

}
