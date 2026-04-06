package com.practise.employee.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.practise.employee.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoIMPL implements EmployeeDao {

	private EntityManager manager;

	public EmployeeDaoIMPL(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Employee> retrieveAllEmployees() {
		TypedQuery<Employee> employeeQuery = manager.createQuery("from Employee", Employee.class);

		List<Employee> theEmployeeList = employeeQuery.getResultList();
		return theEmployeeList;
	}

	@Override
	public Employee findEmployeeById(int employeeId) {
		Employee employee = manager.find(Employee.class, employeeId);
		return employee;
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		Employee dbEmployee = manager.merge(employee);
		return dbEmployee;
	}

	@Override
	public void deleteById(int employeeId) {
		Employee employee = manager.find(Employee.class, employeeId);
		manager.remove(employee);

	}

}
