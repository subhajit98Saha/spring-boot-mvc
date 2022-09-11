package com.springproject.demo1;

public class CricketCoach implements Coach {
	
	private String emailAddress;
	private String team;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Cricketcoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Cricketcoach: inside setter method - setTeam");
		this.team = team;
	}

	private FortuneService fortuneService;
	
	public CricketCoach() {
		System.out.println("Cricketcoach: inside no-arg constructor");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricketcoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		
		return "Practice Fast boling for 15 minitues";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
