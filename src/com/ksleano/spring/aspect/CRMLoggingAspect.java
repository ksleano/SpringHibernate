package com.ksleano.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger, inclduded in java
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.ksleano.spring.controller.*.*(..))")
	private void pointcutControllerPackage() {};
	
	// service and dao pointcut declarations
	@Pointcut("execution(* com.ksleano.spring.service.*.*(..))")
	private void pointcutServicePackage() {};
	
	@Pointcut("execution(* com.ksleano.spring.dao.*.*(..))")
	private void pointcutDaoPackage() {};
	
	@Pointcut("pointcutControllerPackage() || pointcutServicePackage() || pointcutDaoPackage()")
	private void pointcutTriad() {};
	
	// add @Before Advice
	@Before("pointcutTriad()")
	public void before(JoinPoint joinPoint) {
		// display the method being called
		String method = joinPoint.getSignature().toShortString();
		logger.info("=========>> in @Before: calling method: "+ method);
		
		
		// get the args
		Object[] args = joinPoint.getArgs();

		
		// loop and display the args
		for(Object o: args) {
			logger.info("====> argument "+ o);
		}
	}
	
	@AfterReturning( pointcut="pointcutTriad()",
					 returning="result"
	)
	public void afterReturning(JoinPoint joinPoint, Object result){
		
		// display the method being called
		String method = joinPoint.getSignature().toShortString();
		logger.info("=========>> in @AfterReturning: calling method: "+ method);
		
		// display data being returned
		logger.info("=========>> result " + result);
		
				
	}
	
	
	
	
	// add @AfterReturning advice
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
