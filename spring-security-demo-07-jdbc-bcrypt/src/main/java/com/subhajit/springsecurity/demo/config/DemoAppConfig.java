package com.subhajit.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.subhajit.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	//set up variable to hold the properties
	@Autowired
	private Environment env;
	
	//Set up logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//define a bean for viewResolver
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	//Define a bean for our security datasource
	
	@Bean
	public DataSource securityDataSource() {
		//create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		//Set the jDBC driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			// TODO Auto-generated catch block
			throw new RuntimeException(exc);
		}
		
		//log the connection pool
		logger.info("JDBC.url==="+env.getProperty("jdbc.url"));
		logger.info("JDBC.user==="+env.getProperty("jdbc.user"));
		
		//set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//set connection pool props
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	//Need helper method
	//read envirment property and convert to int
	
	private int getIntProperty(String propName) {
		String propval = env.getProperty(propName);
		
		int intPropVal = Integer.parseInt(propval);
		
		return intPropVal;
	}
}
