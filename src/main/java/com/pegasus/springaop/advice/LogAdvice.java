package com.pegasus.springaop.advice;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

public class LogAdvice {

	//1前置增强；
	public void log(JoinPoint joinPoint) {
		
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		MethodSignature methodSignature=(MethodSignature) signature;//1方法签名；
		Method method = methodSignature.getMethod();
		Object[] args = joinPoint.getArgs();//2方法参数；
		Object target = joinPoint.getThis();//3目标对象；
		
		System.out.println(methodName+" is start: ["+new Date().getTime()+"],method args: "+Arrays.toString(args));
	}
	//2后置增加，有返回值；
	public void logAfter(JoinPoint joinPoint,Object returnValue) {
		
		System.out.println("I am logAfter().");
		System.out.println("returnValue: "+returnValue);
	}
	//3异常增加，有异常对象；
	public void logException(JoinPoint joinPoint,Exception e) {
		
		System.out.println("I am logException. Exception is : "+e);
	}
	
	public Object logInterceptor(ProceedingJoinPoint pJoinPoint) throws Throwable {
		
		Object result=null;
		long startTime=System.currentTimeMillis();
		System.out.println("方法开始执行...");
		//2业务逻辑方法；
		result = pJoinPoint.proceed();
		
		//3.后置增强；
		long endTime=System.currentTimeMillis();
		System.out.println(pJoinPoint.getSignature().getName()+" :方法执行后，共用时： "+(endTime-startTime));
		return result;
	}
	
}
