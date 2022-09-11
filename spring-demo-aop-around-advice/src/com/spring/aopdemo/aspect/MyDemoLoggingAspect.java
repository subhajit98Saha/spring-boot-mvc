package com.spring.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;
import com.spring.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	private Logger myLogger = Logger.getLogger(getClass().getName());
	@Around("execution(* com.spring.aopdemo.service.TrafficFortuneService.getFortune(..))")
	public Object aroudGetFortune(ProceedingJoinPoint theProceedingJoinPoint)throws Throwable{
		
		//print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n====> Executing @Around on method: "+method);
		//get begin timestamp
		long begin = System.currentTimeMillis();
		
		//now, let's execute the method
		Object result = null;
		
		try {
			result=theProceedingJoinPoint.proceed();
		} catch (Throwable e) {
			//log the exception
			myLogger.warning(e.getMessage());
			
			//give user a custom message
			result = "On the way!";
			
			//rethrow exceception
			throw e;
		}
		
		//get end timestamp
		long end = System.currentTimeMillis();
		
		//compute duration and display it
		long duration = end-begin;
		myLogger.info("\n====> Duration: "+ duration/1000.0 + "seconds");
		return result;
	}
	@Before("com.spring.aopdemo.aspect.LuvAopExression.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		myLogger.info("\n====>>>Executing @Before advice on Demo method");
		
		//display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: "+ methodSig);
		
		//display method arguments
		
		//get args
		Object[] args=theJoinPoint.getArgs();
		
		for(Object tempArg:args) {
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				
				myLogger.info("Account nmae: "+theAccount.getName());
				myLogger.info("Account level: "+theAccount.getLevel());
			}
		}
	}
}
