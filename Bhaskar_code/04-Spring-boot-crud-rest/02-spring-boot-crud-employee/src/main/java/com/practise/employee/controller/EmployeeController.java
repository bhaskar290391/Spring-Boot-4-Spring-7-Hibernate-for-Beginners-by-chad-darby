package com.practise.employee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practise.employee.entity.Employee;
import com.practise.employee.service.EmployeeService;

import tools.jackson.databind.json.JsonMapper;

@RestController
public class EmployeeController {

	private EmployeeService service;
	private JsonMapper mapper;

	public EmployeeController(EmployeeService service, JsonMapper mapper) {
		super();
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> retieveEmployees() {

		List<Employee> allEmployees = service.retrieveAllEmployees();
		return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
	}

	@GetMapping("/employees/{employeeId}")
	public Employee retieveEmployeById(@PathVariable int employeeId) {

		Employee employee = service.findEmployeeById(employeeId);

		if (employee == null) {
			throw new RuntimeException("Student with id not found" + employeeId);
		}

		return employee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployeeById(@PathVariable int employeeId) {

		Employee employee = service.findEmployeeById(employeeId);

		if (employee == null) {
			throw new RuntimeException("Student with id not found" + employeeId);
		}

		service.deleteById(employeeId);

		return "Employee with Id is deleted" + employeeId;
	}

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		return service.saveEmployee(employee);
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@PatchMapping("/employees/{employeeId}")
	public Employee patchMappingPfEmployee(@PathVariable int employeeId, Map<String, Object> patchValue) {

		Employee tempemloyee = service.findEmployeeById(employeeId);

		if (tempemloyee == null) {
			throw new RuntimeException("Student with id not found" + employeeId);
		}

		if (patchValue.containsKey("id")) {
			throw new RuntimeException("Invalid Request");
		}

		Employee updateEmployee = mapper.updateValue(tempemloyee, patchValue);
		System.out.println(patchValue);
		System.out.println(updateEmployee);
		return service.saveEmployee(updateEmployee);
	}

}
