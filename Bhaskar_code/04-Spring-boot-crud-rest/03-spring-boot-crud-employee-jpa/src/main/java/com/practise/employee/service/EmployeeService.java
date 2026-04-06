package com.practise.employee.service;

import java.util.List;
import java.util.Optional;

import com.practise.employee.entity.Employee;

public interface EmployeeService {

	List<Employee> retrieveAllEmployees();

	Optional<Employee> findEmployeeById(int employeeId);

	Employee saveEmployee(Employee employee);

	void deleteById(int employeeId);
}
