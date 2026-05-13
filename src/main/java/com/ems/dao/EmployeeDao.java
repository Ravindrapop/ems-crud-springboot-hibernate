package com.ems.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ems.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(Long id);
	
	public Employee createEmployee(Employee employee);
	
	public Employee update(Employee employee);
	
	public void delete(Employee employee);

}
