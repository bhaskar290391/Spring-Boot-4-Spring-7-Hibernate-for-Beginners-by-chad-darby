package com.practise.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practise.employee.dao.EmployeeRepository;
import com.practise.employee.entity.Employee;

@Service
@Transactional
public class EmployeeServiceIMPL implements EmployeeService {

	private EmployeeRepository employeeRepo;

	public EmployeeServiceIMPL(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public List<Employee> retrieveAllEmployees() {

		return employeeRepo.findAll();
	}

	@Override
	public Optional<Employee> findEmployeeById(int employeeId) {

		Optional<Employee> employee = employeeRepo.findById(employeeId);
		return employee;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	@Override
	public void deleteById(int employeeId) {
		employeeRepo.deleteById(employeeId);

	}

}
