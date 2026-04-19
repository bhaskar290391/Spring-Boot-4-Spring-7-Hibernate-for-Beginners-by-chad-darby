package com.practise.aop.dao;

import com.practise.aop.model.Account;

public interface AccountDao {

	public void addAccount(Account account, boolean vipFlag);

	public boolean doWork();

	public void setName(String name);

	public String getName();

	public void setServiceCode(String serviceCode);

	public String getServiceCode();

}
