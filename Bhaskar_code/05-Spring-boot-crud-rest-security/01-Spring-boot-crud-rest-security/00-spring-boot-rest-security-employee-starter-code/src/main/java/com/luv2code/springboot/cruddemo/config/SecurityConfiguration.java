package com.luv2code.springboot.cruddemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {

	public InMemoryUserDetailsManager manager() {

		UserDetails bhaskar = User.builder().username("bhaskar").password("{noop}bhaskar").roles("ENPLOYEE").build();

		UserDetails kanishk = User.builder().username("kanishk").password("{noop}kanishk").roles("EMPLOYEE", "MANAGER")
				.build();

		UserDetails samyuktha = User.builder().username("samyuktha").password("{noop}samyuktha")
				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();

		return new InMemoryUserDetailsManager(bhaskar, kanishk, samyuktha);
	}
}
