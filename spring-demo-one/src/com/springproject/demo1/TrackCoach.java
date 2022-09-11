package com.springproject.demo1;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService theFortuneService) {
		super();
		this.fortuneService = theFortuneService;
	}

	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDailyWorkOut() {
		return "Run a hard 5K";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do it: "+ fortuneService.getFortune();
	}

	//add an init method
	public void doStartUpStaff() {
		System.out.println("TrackCoach: inside method doStartUpStaff");
	}
	
	//add a destroy method
	public void doCleanUpStaff() {
		System.out.println("TrackCoach: inside method doCleanUpStaff");
	}
}
