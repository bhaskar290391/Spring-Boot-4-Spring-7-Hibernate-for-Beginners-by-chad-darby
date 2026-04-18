package com.practise.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

	// @Before("execution (public void addAccount())")
	// @Before("execution (public void updateAccount())")
	// @Before("execution (public void
	// com.practise.aop.dao.AccountDao.addAccount())")
	// @Before("execution (public void add*())")
	@Before("execution (* add*())")
	public void beforeAdviceTest() {
		System.out.println("\n ==> adding @Before advice to the Dao implementation");
	}
}
