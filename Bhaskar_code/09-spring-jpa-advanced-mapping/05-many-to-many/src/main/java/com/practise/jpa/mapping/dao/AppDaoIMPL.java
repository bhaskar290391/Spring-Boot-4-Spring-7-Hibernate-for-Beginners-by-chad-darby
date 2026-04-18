package com.practise.jpa.mapping.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.practise.jpa.mapping.entity.Course;
import com.practise.jpa.mapping.entity.Instructor;
import com.practise.jpa.mapping.entity.InstructorDetails;
import com.practise.jpa.mapping.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

		List<Course> courses = instructor.getCourses();

		for (Course course : courses) {
			course.setInstructor(null);
		}

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

	@Override
	public List<Course> fetchCourseByInstructorId(int instructorId) {

		TypedQuery<Course> course = manager.createQuery("from Course where instructor.id=:data", Course.class);

		course.setParameter("data", instructorId);

		List<Course> resultList = course.getResultList();

		return resultList;
	}

	@Override
	public Instructor fetchInstructorByIdUsingJoinfetch(int instructorId) {

		TypedQuery<Instructor> instructor = manager.createQuery("select i from Instructor i " + "join fetch i.courses "
				+ "join fetch i.instructorDetails " + " where i.id=:data", Instructor.class);

		instructor.setParameter("data", instructorId);

		Instructor data = instructor.getSingleResult();

		return data;
	}

	@Override
	@Transactional
	public void updateIntructor(Instructor tempIntructor) {
		manager.merge(tempIntructor);
	}

	@Override
	@Transactional
	public void updateCourse(Course tempCourse) {
		manager.merge(tempCourse);
	}

	@Override
	public Course findCourseById(int courseId) {
		Course course = manager.find(Course.class, courseId);
		return course;
	}

	@Override
	@Transactional
	public void deleteCourseById(int courseId) {
		Course course = manager.find(Course.class, courseId);
		manager.remove(course);
	}

	@Override
	@Transactional
	public void save(Course tempCourse) {
		manager.persist(tempCourse);
	}

	@Override
	public Course findCourseWithReview(int courseId) {
		TypedQuery<Course> course = manager
				.createQuery("select c from Course c " + " join fetch c.reviews " + " where c.id=:data", Course.class);

		course.setParameter("data", courseId);

		Course data = course.getSingleResult();

		return data;

	}

	@Override
	public Course findCourseAndStudentByJoinFetch(int courseId) {
		TypedQuery<Course> course = manager
				.createQuery("select c from Course c " + " join fetch c.students " + " where c.id=:data", Course.class);

		course.setParameter("data", courseId);

		Course data = course.getSingleResult();

		return data;
	}

	@Override
	public Student findStudentAndcourseByJoinFetch(int studentId) {
		TypedQuery<Student> student = manager.createQuery(
				"select s from Student s " + " join fetch s.courses " + " where s.id=:data", Student.class);

		student.setParameter("data", studentId);

		Student data = student.getSingleResult();

		return data;
	}

	@Override
	public Student findStudentById(int studentId) {
		Student student = manager.find(Student.class, studentId);
		return student;
	}

	@Override
	@Transactional
	public void updateStudent(Student data) {
		manager.merge(data);
	}

}
