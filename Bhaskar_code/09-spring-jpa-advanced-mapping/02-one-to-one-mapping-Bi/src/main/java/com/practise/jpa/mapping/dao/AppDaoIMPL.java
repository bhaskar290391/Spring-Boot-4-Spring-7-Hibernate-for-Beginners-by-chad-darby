package com.practise.jpa.mapping.dao;

import org.springframework.stereotype.Repository;

import com.practise.jpa.mapping.entity.Instructor;
import com.practise.jpa.mapping.entity.InstructorDetails;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDaoIMPL implements AppDao {

	private EntityManager manager;

	public AppDaoIMPL(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	@Transactional
	public void save(Instructor instructor) {
		manager.persist(instructor);
	}

	@Override
	public Instructor getInstructor(long id) {

		return manager.find(Instructor.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int instructorId) {

		Instructor instructor = manager.find(Instructor.class, instructorId);
		manager.remove(instructor);

	}

	@Override
	public InstructorDetails findInstructorDetailById(long id) {
		return manager.find(InstructorDetails.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int instructorDetailsId) {
		InstructorDetails instructorDetails = manager.find(InstructorDetails.class, instructorDetailsId);
		instructorDetails.getInstructor().setInstructorDetails(null);
		manager.remove(instructorDetails);

	}

}
