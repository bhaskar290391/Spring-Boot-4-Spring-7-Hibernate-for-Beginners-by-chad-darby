package com.practise.springboot.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class BaseBallCoach implements Coach {

	public BaseBallCoach() {
		System.out.println("Inside the constructor ==>" + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practise Batting for 1 hrs";
	}

}
