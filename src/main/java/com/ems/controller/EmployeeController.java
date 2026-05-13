package com.ems.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	 // GET /api/v1/employees
	@GetMapping
	public List<Employee> getAllEmployees() {

		return employeeService.getAllEmployees();

	}
	//api/v1/employees/1
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		
		Employee employee = employeeService.getEmployeeById(id);
		return employee;
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		
		System.out.println(employee.getId()+" "+employee.getName()+" "+employee.getSalary());
		
		employeeService.createEmployee(employee);
		
		return null;
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee){
		
		
		return ResponseEntity.ok(employeeService.update(id, employee));
		
	}

}
