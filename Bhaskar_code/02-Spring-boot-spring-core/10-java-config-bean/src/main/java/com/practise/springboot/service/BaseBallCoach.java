package com.practise.springboot.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope(value = "prototype")
public class BaseBallCoach implements Coach {

	public BaseBallCoach() {
		System.out.println("Inside the constructor ==>" + getClass().getSimpleName());
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Post initialization data");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("pre Destroy data");
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practise Batting for 1 hrs";
	}

}
