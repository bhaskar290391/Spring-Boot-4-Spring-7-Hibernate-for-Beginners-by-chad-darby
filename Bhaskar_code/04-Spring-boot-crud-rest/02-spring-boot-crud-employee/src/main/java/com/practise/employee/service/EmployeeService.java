package com.practise.employee.service;

import java.util.List;

import com.practise.employee.entity.Employee;

public interface EmployeeService {

	List<Employee> retrieveAllEmployees();

	Employee findEmployeeById(int employeeId);

	Employee saveEmployee(Employee employee);

	void deleteById(int employeeId);
}
