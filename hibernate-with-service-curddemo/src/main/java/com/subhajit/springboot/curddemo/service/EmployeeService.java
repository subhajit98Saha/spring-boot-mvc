package com.subhajit.springboot.curddemo.service;

import java.util.List;

import com.subhajit.springboot.curddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
