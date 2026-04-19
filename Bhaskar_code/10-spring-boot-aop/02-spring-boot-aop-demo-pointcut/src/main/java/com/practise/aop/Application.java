package com.practise.aop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.practise.aop.dao.AccountDao;
import com.practise.aop.dao.MembershipDao;
import com.practise.aop.model.Account;

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
		Account account = new Account();
		accountDao.addAccount(account, true);
		accountDao.doWork();
		accountDao.setName("Bhaskar");
		accountDao.setServiceCode("Bhas123");

		String name = accountDao.getName();
		String service = accountDao.getServiceCode();

		membershipDao.addSillyAccount();
		membershipDao.doSleep();

	}
}
