package com.practise.aop;

import com.practise.aop.dao.AccountDaoImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.practise.aop.dao.AccountDao;
import com.practise.aop.dao.MembershipDao;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao) {
		return runner -> {

			beforeAdviceForAspectProgramming(accountDao, membershipDao);

		};
	}

	private void beforeAdviceForAspectProgramming(AccountDao accountDao, MembershipDao membershipDao) {
		accountDao.addAccount();
		membershipDao.addAccount();

	}
}
