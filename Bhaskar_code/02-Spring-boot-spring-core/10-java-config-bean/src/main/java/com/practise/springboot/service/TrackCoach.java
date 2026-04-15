package com.practise.springboot.service;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
	
	public TrackCoach() {
		System.out.println("Inside the constructor ==>" + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		
		return "Runnning hard 5 km";
	}

}
