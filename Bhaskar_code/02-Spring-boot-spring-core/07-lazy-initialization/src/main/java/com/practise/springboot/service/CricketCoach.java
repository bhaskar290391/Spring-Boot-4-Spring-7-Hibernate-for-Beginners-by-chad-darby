package com.practise.springboot.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("Inside the constructor ==>" + getClass().getSimpleName());
	}
	@Override
	public String getDailyWorkout() {

		return "Practise Fast bowling for 1 hrs";
	}

}
