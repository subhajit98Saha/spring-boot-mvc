package com.springproject.demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		//Lod the spring configuration file
		ClassPathXmlApplicationContext conext = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve the bean from spring container
		Coach theCoach = conext.getBean("myTrack", Coach.class);
		Coach alphaCoach = conext.getBean("myTrack", Coach.class);
		
		//check if they are same
		boolean result = (theCoach == alphaCoach);
		System.out.println("\nPointing to the same object: "+ result);
		System.out.println("\nmemory location for theCoach: "+ theCoach);
		System.out.println("\nmempry location for alphaCoach: "+ alphaCoach);
		
		//close the context
		conext.close();
	}

}
