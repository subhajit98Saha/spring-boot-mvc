package com.spring.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//call the method to find the accounts
		List<Account> theAccounts = null;
		try {
			//add a boolean flag to simulate exception
			boolean tripWire = true;
			theAccounts =theAccountDAO.findAccounts(tripWire);
		}catch (Exception e) {
			System.out.println("\n\nMain Program ... caught exception: "+e );
		}
		
		
		//display the acconts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("----");
		
		System.out.println( theAccounts);
		System.out.println("\n");
		
		//close the context
		context.close();
	}

}
