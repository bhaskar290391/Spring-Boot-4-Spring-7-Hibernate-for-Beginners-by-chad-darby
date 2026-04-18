package com.practise.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl implements AccountDao {

	@Override
	public void addAccount() {
		System.out.println("\n "+getClass() + " ==>  Adding DB related work");
	}

}

