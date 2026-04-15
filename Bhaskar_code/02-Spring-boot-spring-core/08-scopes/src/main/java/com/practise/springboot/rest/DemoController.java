package com.practise.springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.springboot.service.Coach;

@RestController
public class DemoController {

	private Coach theCoach;

	private Coach theAnotherCoach;

	@Autowired
	public void setTheCoach(@Qualifier("baseBallCoach") Coach theCoach,
			@Qualifier("baseBallCoach") Coach theAnotherCoach) {
		System.out.println("Inside the constructor ==>" + getClass().getSimpleName());
		this.theCoach = theCoach;
		this.theAnotherCoach = theAnotherCoach;
	}

	@GetMapping("/dailyWorkout")
	public String getDailyWorkout() {
		return theCoach.getDailyWorkout();
	}

	@GetMapping("/check")
	public String checkScopes() {
		return "Checking the scopes " + (theCoach == theAnotherCoach);
	}

}
