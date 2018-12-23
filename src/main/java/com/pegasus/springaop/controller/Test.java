package com.pegasus.springaop.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pegasus.springaop.service.ICalcService;
import com.pegasus.springaop.service.IUserService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("./spring-aop/applicationContext.xml");
		IUserService userService = (IUserService) ac.getBean("userService");
		userService.login("Pegasus", "123");
		System.out.println("-----------------------------");
		
		System.out.println(userService.logout());
		
		System.out.println("-----------------");
		
		System.out.println(userService.getClass());
		
		ICalcService calcService = (ICalcService) ac.getBean("calcService");
		int add = calcService.add(22, 2);
		System.out.println(add);
	}

}
