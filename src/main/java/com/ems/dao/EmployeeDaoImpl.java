package com.ems.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ems.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private final SessionFactory sessionFactory;

	public EmployeeDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Employee> getAllEmployees() {

		Session session = sessionFactory.getCurrentSession();

		List<Employee> list = session.createQuery("FROM Employee", Employee.class).list();
		return list;
	}

	@Override
	public Employee getEmployeeById(Long id) {

		Session session = sessionFactory.getCurrentSession();

		Employee employee = session.get(Employee.class, id);

		return employee;

	}

	@Override
	public Employee createEmployee(Employee employee) {
		System.out.println("Dao: " + employee.getId() + " " + employee.getName() + " " + employee.getSalary());

		Session session = sessionFactory.getCurrentSession();

		session.persist(employee);

		return employee;
	}

	@Override
	public Employee update(Employee employee) {
		return (Employee) sessionFactory.getCurrentSession().merge(employee);
	}

}
