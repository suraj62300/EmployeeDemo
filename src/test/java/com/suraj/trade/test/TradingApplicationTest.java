package com.suraj.trade.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.suraj.trade.model.Employee;
import com.suraj.trade.repository.EmployeeRepository;

@SpringBootTest
public class TradingApplicationTest {

	@Autowired
	EmployeeRepository employeeRepository; 
	
	@Test
	public void testCreateEmployee() {
		
		System.out.println(employeeRepository);
		Employee entity = new Employee();
		entity.setName("Suraj");
		entity.setDesignation("Seclore Developer");
		entity.setSalary(12000d);
		//employeeRepository.save(entity);
		System.out.println(entity);
	}
	
	@Test
	public void testSuraj() {
		System.out.println(employeeRepository);
	}
}
