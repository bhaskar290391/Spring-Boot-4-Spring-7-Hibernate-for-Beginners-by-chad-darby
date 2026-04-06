package com.practise.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practise.employee.dao.EmployeeDao;
import com.practise.employee.entity.Employee;

@Service
@Transactional
public class EmployeeServiceIMPL implements EmployeeService {

	private EmployeeDao employeeRepo;

	public EmployeeServiceIMPL(EmployeeDao employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public List<Employee> retrieveAllEmployees() {

		return employeeRepo.retrieveAllEmployees();
	}

	@Override
	public Employee findEmployeeById(int employeeId) {

		return employeeRepo.findEmployeeById(employeeId);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.saveEmployee(employee);
	}

	@Override
	public void deleteById(int employeeId) {
		employeeRepo.deleteById(employeeId);

	}

}
