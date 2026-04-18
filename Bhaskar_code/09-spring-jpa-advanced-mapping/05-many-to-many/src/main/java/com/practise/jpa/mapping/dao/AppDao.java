package com.practise.jpa.mapping.dao;

import java.util.List;

import com.practise.jpa.mapping.entity.Course;
import com.practise.jpa.mapping.entity.Instructor;
import com.practise.jpa.mapping.entity.InstructorDetails;

public interface AppDao {

	public void save(Instructor instructor);

	public Instructor getInstructor(long id);

	public void deleteInstructorById(int instructorId);

	public InstructorDetails findInstructorDetailById(long id);

	public void deleteInstructorDetailById(int instructorId);

	public List<Course> fetchCourseByInstructorId(int instructorId);

	public Instructor fetchInstructorByIdUsingJoinfetch(int instructorId);
	
	public void updateIntructor(Instructor tempIntructor);

	public void updateCourse(Course tempCourse);
	
	public Course findCourseById(int courseId);

	void deleteCourseById(int courseId);
	
	public void save(Course tempCourse);
	
	public Course findCourseWithReview(int id);

}
