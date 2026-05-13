package com.ems.service;

import java.util.List;

import com.ems.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(Long id);
	
	public Employee createEmployee(Employee employee);
	
	public Employee update(Long id, Employee employee);
	
	public void delete(Long id);

}
