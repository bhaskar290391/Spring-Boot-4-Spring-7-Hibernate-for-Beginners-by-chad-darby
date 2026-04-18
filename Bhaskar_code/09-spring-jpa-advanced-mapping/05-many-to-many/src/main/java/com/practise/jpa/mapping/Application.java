package com.practise.jpa.mapping;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.practise.jpa.mapping.dao.AppDao;
import com.practise.jpa.mapping.entity.Course;
import com.practise.jpa.mapping.entity.Instructor;
import com.practise.jpa.mapping.entity.InstructorDetails;
import com.practise.jpa.mapping.entity.Reviews;
import com.practise.jpa.mapping.entity.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner dataRunner(AppDao appDao) {
		return runner -> {

			// createCourseAndStudent(appDao);
			// findCourseAndStudentsByJoinFetch(appDao);
			// findStudentAndCourseByJoinFetch(appDao);
			//UpdateMoreCoursesForStudent(appDao);
			deleteCourseById(appDao);
		};
	}

	private void UpdateMoreCoursesForStudent(AppDao appDao) {

		int studentId = 1;

		Student data = appDao.findStudentAndcourseByJoinFetch(studentId);

		Course tempCourse = new Course("Angular pratise");
		Course tempCourse1 = new Course("Microservice");

		data.add(tempCourse);
		data.add(tempCourse1);

		appDao.updateStudent(data);

	}

	private void findStudentAndCourseByJoinFetch(AppDao appDao) {

		int studentId = 1;

		Student tempStudent = appDao.findStudentAndcourseByJoinFetch(studentId);

		System.out.println(tempStudent);

		System.out.println(tempStudent.getCourses());

	}

	private void findCourseAndStudentsByJoinFetch(AppDao appDao) {

		int courseId = 10;

		Course tempCourse = appDao.findCourseAndStudentByJoinFetch(courseId);

		System.out.println(tempCourse);

		System.out.println(tempCourse.getStudents());

	}

	private void createCourseAndStudent(AppDao appDao) {

		Course tempCourse = new Course("The Java full stack");

		Student stud = new Student("Bhaskar", "Mudaliyar", "bhaskar@gmail.com");
		Student stud1 = new Student("Maddy", "Mudaliyar", "Maddy@gmail.com");
		Student stud2 = new Student("Kanishk", "Mudaliyar", "Kanishk@gmail.com");

		tempCourse.add(stud);
		tempCourse.add(stud1);
		tempCourse.add(stud2);

		appDao.save(tempCourse);
		System.out.println("Done !!!!");

	}

	private void findCourseWithReviews(AppDao appDao) {
		int courseId = 11;

		System.out.println("Finding the Course Id");
		Course courseWithReview = appDao.findCourseWithReview(courseId);
		System.out.println("Course ==>" + courseWithReview);
		System.out.println("CourseWithReview ==>" + courseWithReview.getReviews());
	}

	private void saveCourseWithReviews(AppDao appDao) {
		Course theCourse = new Course("The pacman game for adult");

		theCourse.add(new Reviews("Nice Course"));
		theCourse.add(new Reviews("Nice Course---> with good knowledge"));
		theCourse.add(new Reviews("Nice Course---> with good basic"));

		System.out.println("Saving the course ");
		appDao.save(theCourse);
	}

	private void deleteCourseById(AppDao appDao) {
		int courseId = 11;

		appDao.deleteCourseById(courseId);

		System.out.println("Done !!!");
	}

	private void updateCourserById(AppDao appDao) {
		int courseId = 10;

		Course courseById = appDao.findCourseById(courseId);

		System.out.println("Course ==>" + courseById);

		courseById.setTitle("Bhaksar data fetching");

		appDao.updateCourse(courseById);

	}

	private void updateInstructorById(AppDao appDao) {

		Instructor instructor = appDao.getInstructor(1);

		System.out.println("Instructor ==> " + instructor);

		instructor.setEmail("mudaliyarbhaskar29@gmail.com");
		appDao.updateIntructor(instructor);
	}

	private void fetchInstructorWithCoursesUsingJoinFetch(AppDao appDao) {
		int instructorid = 1;

		System.out.println("fetching instructor Details");

		Instructor instructor = appDao.fetchInstructorByIdUsingJoinfetch(instructorid);

		System.out.println("Instructor" + instructor);

		System.out.println("Find the courses " + instructor.getCourses());

		System.out.println("Find the instructor Details " + instructor.getCourses());

	}

	private void fetchCourseForInstructor(AppDao appDao) {

		int instructorid = 1;

		System.out.println("fetching instructor Details");

		Instructor instructor = appDao.getInstructor(instructorid);

		System.out.println("Instructor" + instructor);

		List<Course> fetchCourseByInstructorId = appDao.fetchCourseByInstructorId(instructorid);

		instructor.setCourses(fetchCourseByInstructorId);

		System.out.println("Find the courses " + instructor.getCourses());
	}

	private void fetchInstructorWithCourses(AppDao appDao) {
		int instructorid = 1;

		System.out.println("fetching instructor Details");

		Instructor instructor = appDao.getInstructor(instructorid);

		System.out.println("Instructor" + instructor);
		System.out.println("Find the courses " + instructor.getCourses());

	}

	private void createInstructor(AppDao appDao) {

		Instructor instructor = new Instructor("bhaskar", "mudaliyar", "mudaliyar@gmail.com");
		InstructorDetails details = new InstructorDetails("bhaskar@youtube.com", "cricket");

		instructor.setInstructorDetails(details);

		System.out.println("Saving an instructor");
		appDao.save(instructor);
		System.out.println("Done !!!");

	}

	private void getInstructor(AppDao appDao) {

		int instructorId = 1;

		Instructor data = appDao.getInstructor(instructorId);

		System.out.println(data);
		System.out.println("Instructor Details Data " + data.getInstructorDetails());

	}

	private void deleteInstructorById(AppDao appDao) {
		int instructorId = 1;

		appDao.deleteInstructorById(instructorId);

		System.out.println("Delete done !!!");

	}

	private void findInstructorDetails(AppDao appDao) {

		int instructorDetailsId = 2;

		InstructorDetails instructorDetails = appDao.findInstructorDetailById(instructorDetailsId);
		System.out.println(instructorDetails);

		System.out.println("Instructor Deatils " + instructorDetails.getInstructor());
	}

	private void deleteInstructorDetailById(AppDao appDao) {
		int instructorDetailsId = 2;
		appDao.deleteInstructorDetailById(instructorDetailsId);
	}

	private void createCourseByUsingInstructor(AppDao appDao) {
		Instructor instructor = new Instructor("bhaskar", "mudaliyar", "mudaliyar@gmail.com");
		InstructorDetails details = new InstructorDetails("bhaskar@youtube.com", "cricket");

		Course course1 = new Course("java Full stack");
		Course course2 = new Course("Angular");

		instructor.add(course1);
		instructor.add(course2);
		instructor.setInstructorDetails(details);

		System.out.println("Saving an instructor");
		appDao.save(instructor);
		System.out.println("Done !!!");
	}

}
