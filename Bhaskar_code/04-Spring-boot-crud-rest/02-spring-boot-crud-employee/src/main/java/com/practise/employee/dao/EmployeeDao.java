package com.practise.employee.dao;

import java.util.List;

import com.practise.employee.entity.Employee;

public interface EmployeeDao {

	List<Employee> retrieveAllEmployees();

	Employee findEmployeeById(int employeeId);

	Employee saveEmployee(Employee employee);

	void deleteById(int employeeId);

}
