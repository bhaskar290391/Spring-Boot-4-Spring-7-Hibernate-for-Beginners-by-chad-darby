package com.practise.jpa.hibernate.dao;

import java.util.List;

import com.practise.jpa.hibernate.entity.Student;

public interface StudentDao {

	public void save(Student student);

	public Student findById(int studentId);

	public List<Student> findAll();

	public List<Student> findByLastName(String lastname);

	public Student update(Student student);

	public void delete(int studentId);

}
