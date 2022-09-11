package com.springproject.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFortune implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		int max = 14;
		int min = 0;
		int diff = max - min;
		Random rn = new Random();
		int i = rn.nextInt(diff + 1);
		i += min;
		
		List<String> lt = new ArrayList<String>();
		lt.add("Fortune1");
		lt.add("Fortune2");
		lt.add("Fortune3");
		lt.add("Fortune4");
		lt.add("Fortune5");
		lt.add("Fortune6");
		lt.add("Fortune7");
		lt.add("Fortune8");
		lt.add("Fortune9");
		lt.add("Fortune10");
		lt.add("Fortune11");
		lt.add("Fortune12");
		lt.add("Fortune13");
		lt.add("Fortune14");
		lt.add("Fortune15");
		return lt.get(i);
	}

}
