package com.practise.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDaoImpl implements MembershipDao {

	@Override
	public boolean addSillyAccount() {
		System.out.println(getClass() + " ==>  Adding DB related work : MembershipDaoImpl");
		return true;
	}

}

