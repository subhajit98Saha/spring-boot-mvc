package com.spring.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;
import com.spring.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("\nMain program: AroundDempApp");
		
		myLogger.info("Calling getFortune");
		
		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMy fortune is: "+data);
		
		myLogger.info("Finished");
		//close the context
		context.close();
	}

}
