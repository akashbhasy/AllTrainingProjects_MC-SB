package com.ust.pms.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProductServiceAspects {


	@Before(value ="execution(* com.ust.pms.service.ProductService.*(..))")
	public void beforeAdvice( JoinPoint jointpoint) {
		System.out.println("**Before Advice**");
	}
	
	@After(value ="execution(* com.ust.pms.service.ProductService.*(..))")
	public void afterAdvice( JoinPoint jointpoint) {
		Signature method= jointpoint.getSignature();
		System.out.println("**after Advice**"+method.getName());
	}
	
	@Around(value ="execution(* com.ust.pms.service.ProductService.*(..))")
	public Object aroundAdvice( ProceedingJoinPoint jointpoint) throws Throwable {
		Signature method= jointpoint.getSignature();
		System.out.println("**Round Advice**"+method.getName());
		
		Object obj=jointpoint.proceed();
		
		System.out.println("**Round Advice after**"+method.getName());
		return obj;
	}
}
