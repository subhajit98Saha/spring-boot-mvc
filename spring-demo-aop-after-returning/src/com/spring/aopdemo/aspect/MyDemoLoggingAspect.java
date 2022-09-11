package com.spring.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@After("execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccounts(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====> Executing @After finally on method:"+method);
	}
	@AfterThrowing(
			pointcut = "execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint,Throwable theExc) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====> Executing @AfterThrowing on method:"+method);
		
		//log the exception
		System.out.println("\n=====> The Exception is: "+theExc);
	}
	
	
	//add a new advice for @AfterReturning on the findAccounts method
	
	@AfterReturning(pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n===> Executing @AfterReturning on method: "+ method);
		
		//print out the results of the method call
		System.out.println("\n====> result is: "+result);
		
		//let's post-process the data... let's modify it:-
		
		//convert the account names to uppercase
		convertAccountNameToUpperCase(result);
		System.out.println("\n====> result is: "+result);
	}
	
	private void convertAccountNameToUpperCase(List<Account> result) {
		// loop through accounts
		
		for(Account tempAccount: result) {
			//get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			tempAccount.setName(theUpperName);
		}
		
	}

	@Before("com.spring.aopdemo.aspect.LuvAopExression.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n====>>>Executing @Before advice on Demo method");
		
		//display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: "+ methodSig);
		
		//display method arguments
		
		//get args
		Object[] args=theJoinPoint.getArgs();
		
		for(Object tempArg:args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				
				System.out.println("Account nmae: "+theAccount.getName());
				System.out.println("Account level: "+theAccount.getLevel());
			}
		}
	}
}
