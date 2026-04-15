package com.practise.springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.springboot.service.Coach;

@RestController
public class DemoController {

	private Coach theCoach;

	@Autowired
	public void setTheCoach(@Qualifier("swimCoach") Coach theCoach) {
		System.out.println("Inside the constructor ==>" + getClass().getSimpleName());
		this.theCoach = theCoach;

	}

	@GetMapping("/dailyWorkout")
	public String getDailyWorkout() {
		return theCoach.getDailyWorkout();
	}

}
