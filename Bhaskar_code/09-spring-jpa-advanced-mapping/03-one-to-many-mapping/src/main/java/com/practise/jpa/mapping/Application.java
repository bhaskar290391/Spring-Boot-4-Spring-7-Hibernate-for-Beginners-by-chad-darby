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

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner dataRunner(AppDao appDao) {
		return runner -> {

			// createInstructor(appDao);
			// getInstructor(appDao);
			// deleteInstructorById(appDao);
			// findInstructorDetails(appDao);
			// deleteInstructorDetailById(appDao);

			// createCourseByUsingInstructor(appDao);
			// fetchInstructorWithCourses(appDao);

			fetchCourseForInstructor(appDao);
		};
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
