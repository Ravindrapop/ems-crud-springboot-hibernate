package com.ems.service;

import java.util.List;

import com.ems.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(Long id);
	
	public Employee createEmployee(Employee employee);

}
