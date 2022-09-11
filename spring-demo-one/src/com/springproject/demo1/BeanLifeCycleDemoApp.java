package com.springproject.demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		//Lod the spring configuration file
		ClassPathXmlApplicationContext conext = 
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		//retrieve the bean from spring container
		Coach theCoach = conext.getBean("myTrack", Coach.class);
		
		System.out.println(theCoach.getDailyWorkOut());
		
		//close the context
		conext.close();
	}

}
