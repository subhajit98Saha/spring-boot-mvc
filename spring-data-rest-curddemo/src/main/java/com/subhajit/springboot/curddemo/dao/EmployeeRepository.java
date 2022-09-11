package com.subhajit.springboot.curddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.subhajit.springboot.curddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
