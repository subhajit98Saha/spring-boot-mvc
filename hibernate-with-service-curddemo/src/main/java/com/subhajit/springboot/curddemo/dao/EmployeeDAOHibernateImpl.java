package com.subhajit.springboot.curddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.subhajit.springboot.curddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	//define field for entitymanager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		// TODO Auto-generated constructor stub
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);      
		//create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		//return the results
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Session currentSeesion = entityManager.unwrap(Session.class);
		
		Employee theEmployee = currentSeesion.get(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Session currentSeesion = entityManager.unwrap(Session.class);
		
		currentSeesion.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		Session currentSeesion = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSeesion.createQuery("delete from Employee where id=employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
