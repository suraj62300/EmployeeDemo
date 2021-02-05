package com.suraj.trade.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.suraj.trade.model.Employee;
import com.suraj.trade.repository.EmployeeRepository;
import com.suraj.trade.service.EmployeeService;

@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRepository;
	
	/* to save an Employee */
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	/* to search all Employee */
	public List<Employee> getAllEmployees(){
		//return employeeRepository.findAll();
		return (List<Employee>) employeeRepository.findAll();
	}
	
	/* to get an Employee */ 
	public Employee findOne(Long id) {
		//return employeeRepository.findById(id).orElse(null);
		return employeeRepository.findById(id).get();
	}
	
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}
	
	public void save(MultipartFile file) {
		try {
			List<Employee> employees = EmployeeService.csvToEmployee(file.getInputStream());
			employeeRepository.saveAll(employees);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}
	
	
}
