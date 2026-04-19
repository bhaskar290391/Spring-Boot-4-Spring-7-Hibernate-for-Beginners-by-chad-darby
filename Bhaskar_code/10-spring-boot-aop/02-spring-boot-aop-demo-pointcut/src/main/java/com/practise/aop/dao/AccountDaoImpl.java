package com.practise.aop.dao;

import org.springframework.stereotype.Component;

import com.practise.aop.model.Account;

@Component
public class AccountDaoImpl implements AccountDao {

	private String name;

	private String serviceCode;

	@Override
	public String getName() {
		System.out.println(getClass() + " ==>  getName()");
		return name;
	}

	@Override
	public void setName(String name) {
		System.out.println(getClass() + " ==>  setName()");
		this.name = name;
	}

	@Override
	public String getServiceCode() {
		System.out.println(getClass() + " ==>  getServiceCode()");
		return serviceCode;
	}

	@Override
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " ==>  setServiceCode()");
		this.serviceCode = serviceCode;
	}

	@Override
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + " ==>  Adding DB related work");
	}

	@Override
	public boolean doWork() {
		System.out.println(getClass() + " ==> Going to start work ");
		return false;
	}

}
