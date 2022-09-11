package com.springproject.demo1;

public class BaseBallCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public BaseBallCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	} 
	
	@Override
	public String getDailyWorkOut() {
		return "Spend 30 minuites for daily exercise";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
