package com.practise.aop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.practise.aop.dao.AccountDao;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao) {
		return runner ->{
			
			accountDao.addAccount();
			
			System.out.println("\n call the account DAO method again");
			
			accountDao.addAccount();
		};
	}
}
