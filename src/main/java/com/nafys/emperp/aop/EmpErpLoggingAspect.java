package com.nafys.emperp.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class EmpErpLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.nafys.emperp.rest.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.nafys.emperp.service.*.*(..))")
	private void forServicePackage() {}
	
	
	@Pointcut("forControllerPackage() || forServicePackage()")
	public void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinpoint) {
		String method = joinpoint.getSignature().toShortString();
		myLogger.info("====>> in @Before: calling method: "+ method);
		
		Object[] args = joinpoint.getArgs();
		for(Object o: args) {
			myLogger.info("====>> argument : "+ o);
		}
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="result")
	public void afterReturning(JoinPoint joinpoint, Object result) {
		String method = joinpoint.getSignature().toShortString();
		myLogger.info("====>> in @AfterReturning: calling method: "+ method);
		
		myLogger.info("===>> result : "+ result);
	}

}
