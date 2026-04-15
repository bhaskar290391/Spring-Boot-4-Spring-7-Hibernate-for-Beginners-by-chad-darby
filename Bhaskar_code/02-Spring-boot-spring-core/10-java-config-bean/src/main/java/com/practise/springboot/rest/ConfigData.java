package com.practise.springboot.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.practise.springboot.service.Coach;
import com.practise.springboot.service.SwimCoach;

@Configuration
public class ConfigData {

	@Bean
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
