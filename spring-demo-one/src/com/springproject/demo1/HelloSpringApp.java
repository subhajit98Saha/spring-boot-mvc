package com.springproject.demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
	public static void main(String[] args) {
		//Lod the spring configuration file
		ClassPathXmlApplicationContext conext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve the bean from spring container
		Coach theCoach = conext.getBean("myBaseBall", Coach.class);
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkOut());
		
		//let's call our new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		
		//cloase the context
		conext.close();
	}
}
