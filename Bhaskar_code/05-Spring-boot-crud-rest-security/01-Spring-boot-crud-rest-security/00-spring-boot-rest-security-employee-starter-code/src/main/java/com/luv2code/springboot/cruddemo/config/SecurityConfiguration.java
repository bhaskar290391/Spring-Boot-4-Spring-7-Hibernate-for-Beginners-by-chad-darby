package com.luv2code.springboot.cruddemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager manager() {

		UserDetails bhaskar = User.builder().username("bhaskar").password("{noop}bhaskar").roles("EMPLOYEE").build();

		UserDetails kanishk = User.builder().username("kanishk").password("{noop}kanishk").roles("EMPLOYEE", "MANAGER")
				.build();

		UserDetails samyuktha = User.builder().username("samyuktha").password("{noop}samyuktha")
				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();

		return new InMemoryUserDetailsManager(bhaskar, kanishk, samyuktha);
	}

	@Bean
	public SecurityFilterChain security(HttpSecurity http) {

		http.authorizeHttpRequests(config -> 
				config.requestMatchers(HttpMethod.GET, "/api/employees")
				.hasRole("EMPLOYEE").requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PATCH, "/api/employees/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));
		
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}
}
