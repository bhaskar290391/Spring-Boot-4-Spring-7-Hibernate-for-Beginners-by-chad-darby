package com.practise.aop.dao;

import org.springframework.stereotype.Component;

import com.practise.aop.model.Account;

@Component
public class AccountDaoImpl implements AccountDao {

	@Override
	public void addAccount(Account account) {
		System.out.println(getClass() + " ==>  Adding DB related work");
	}

	@Override
	public boolean doWork() {
		System.out.println(getClass() + " ==> Going to start work ");
		return false;
	}

}
