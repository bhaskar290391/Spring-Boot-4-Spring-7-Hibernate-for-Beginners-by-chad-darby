package com.practise.jpa.hibernate.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practise.jpa.hibernate.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDaoIMPL implements StudentDao {

	private EntityManager manager;

	public StudentDaoIMPL(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		manager.persist(student);

	}

	@Override
	public Student findById(int studentId) {

		return manager.find(Student.class, studentId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		List<Student> resultList = manager.createQuery("from Student", Student.class).getResultList();
		return resultList;
	}

	@Override
	public List<Student> findByLastName(String lastName) {

		TypedQuery<Student> query = manager.createQuery("from Student where lastName =:theLastName", Student.class);
		query.setParameter("theLastName", lastName);
		List<Student> resultList = query.getResultList();
		return resultList;
	}

	@Override
	@Transactional
	public Student update(Student student) {
		// TODO Auto-generated method stub
		return manager.merge(student);
	}

	@Override
	@Transactional
	public void delete(int studentId) {
		Student student = manager.find(Student.class, studentId);
		manager.remove(student);

	}

}
