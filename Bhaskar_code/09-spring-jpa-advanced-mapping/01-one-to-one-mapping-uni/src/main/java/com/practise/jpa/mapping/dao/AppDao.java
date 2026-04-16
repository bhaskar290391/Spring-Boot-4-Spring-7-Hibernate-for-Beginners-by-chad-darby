package com.practise.jpa.mapping.dao;

import com.practise.jpa.mapping.entity.Instructor;

public interface AppDao {
 
	public void save(Instructor instructor);
	
	public Instructor getInstructor(long id);

	public void deleteInstructorById(int instructorId);
}
