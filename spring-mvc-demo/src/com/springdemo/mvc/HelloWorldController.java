package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processformVersionTwo")
	public String letsShoutDude(HttpServletRequest request,Model model) {
		
		//read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		//convert the message
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Yo! " + theName;
		
		//add message to the model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processformVersionThree")
	public String processformVersionThree(@RequestParam("studentName")String theName,Model model) {
		
		//convert the message
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Yeah! " + theName;
		
		//add message to the model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
}
