package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.dao.EmployeeDao;
import com.ems.model.Employee;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		
		return employeeDao.getAllEmployees();
		
	}
	
	@Override
	public Employee getEmployeeById(Long id) {
		
		Employee employee = employeeDao.getEmployeeById(id);
		return employee;
	}
	
	@Override
	public Employee createEmployee(Employee employee) {
		System.out.println(employee.getId()+" "+employee.getName()+" "+employee.getSalary());
		
		Employee response = employeeDao.createEmployee(employee);
		
		return response;
	}

}
