package com.subhajit.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping("/")
	public String showHome() {
		return "landing";
	}
	//Add request mapping for /leaders
		@GetMapping("/employees")
		public String showEmployee() {
			return "home";
	}
		
	//Add request mapping for /leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	
	//Add request mapping for /systems
		@GetMapping("/systems")
		public String showSystems() {
			return "systems";
		}
}
