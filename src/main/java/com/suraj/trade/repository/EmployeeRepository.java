package com.suraj.trade.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.suraj.trade.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
}
