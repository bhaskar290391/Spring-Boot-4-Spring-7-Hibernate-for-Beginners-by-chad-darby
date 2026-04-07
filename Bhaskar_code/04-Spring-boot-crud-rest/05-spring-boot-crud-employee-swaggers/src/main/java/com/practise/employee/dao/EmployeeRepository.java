package com.practise.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practise.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
