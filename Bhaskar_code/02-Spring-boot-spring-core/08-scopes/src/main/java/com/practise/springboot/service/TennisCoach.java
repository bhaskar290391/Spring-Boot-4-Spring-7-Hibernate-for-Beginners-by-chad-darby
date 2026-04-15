package com.practise.springboot.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	public TennisCoach() {
		System.out.println("Inside the constructor ==>" + getClass().getSimpleName());
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Parctise with hard tennis";
	}

}
