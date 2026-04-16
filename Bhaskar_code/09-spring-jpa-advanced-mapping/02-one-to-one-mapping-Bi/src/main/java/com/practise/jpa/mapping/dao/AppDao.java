package com.practise.jpa.mapping.dao;

import com.practise.jpa.mapping.entity.Instructor;
import com.practise.jpa.mapping.entity.InstructorDetails;

public interface AppDao {
 
	public void save(Instructor instructor);
	
	public Instructor getInstructor(long id);

	public void deleteInstructorById(int instructorId);
	
	public InstructorDetails findInstructorDetailById(long id);

	public void deleteInstructorDetailById(int instructorId);

}
