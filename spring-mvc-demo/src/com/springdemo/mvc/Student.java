package com.springdemo.mvc;

import java.util.LinkedHashMap;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {
	private String firstName;
	
	@NotNull
	@Size(min=1,message="is required")
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private String[] operatingSystem;
//	private LinkedHashMap<String, String> countryOptions;
	
	public Student() {
		super();
//		countryOptions = new LinkedHashMap<>();
//		countryOptions.put("GE", "Germeny");
//		countryOptions.put("RU", "Russia");
//		countryOptions.put("IN", "India");
//		countryOptions.put("BR", "Brazil");
	}
//	public LinkedHashMap<String, String> getCountryOptions() {
//		return countryOptions;
//	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}
	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	public String[] getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
}
