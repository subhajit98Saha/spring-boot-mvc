package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuvAopExression {
	//this is where we add all of our related advics for logging
	
		//let's start with an @Before advice
		
		@Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))")
		public void forDaoPackage() {}
		
		//create pointcut for getter methods
		@Pointcut("execution(* com.spring.aopdemo.dao.*.get*(..))")
		public void getter() {}
		
		//create pointcut for setter methods
		@Pointcut("execution(* com.spring.aopdemo.dao.*.set*(..))")
		public void setter() {}
		
		//create pointcut: include package .. exclude getter/setter
		@Pointcut("forDaoPackage() && !(getter()||setter())")
		public void forDaoPackageNoGetterSetter() {
			System.out.println("\n====>> executing @Before advice on method");
		}
}
