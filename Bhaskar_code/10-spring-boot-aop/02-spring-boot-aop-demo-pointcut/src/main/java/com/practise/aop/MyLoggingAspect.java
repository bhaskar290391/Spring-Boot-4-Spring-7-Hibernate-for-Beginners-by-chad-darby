package com.practise.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

	
	@Pointcut("execution (* com.practise.aop.dao.*.*(..))")
	public void forDaoPackage() {
	}
	
	
	// @Before("execution (public void addAccount())")
	// @Before("execution (public void updateAccount())")
	// @Before("execution (public void com.practise.aop.dao.AccountDao.addAccount())")
	// @Before("execution (public void add*())")
	//@Before("execution (* add*())")
	//@Before("execution (* add*(com.practise.aop.model.Account))")
	//@Before("execution (* add*(..))")
	//@Before("execution (* com.practise.aop.dao.*.*(..))")
	@Before("forDaoPackage()")
	public void beforeAdviceTest() {
		System.out.println("\n ==> adding @Before advice to the Dao implementation");
	}
	
	
	@Before("forDaoPackage()")
	public void performAnalyticPerformace() {
		System.out.println("\n ==> Analythic performance");
	}
}
