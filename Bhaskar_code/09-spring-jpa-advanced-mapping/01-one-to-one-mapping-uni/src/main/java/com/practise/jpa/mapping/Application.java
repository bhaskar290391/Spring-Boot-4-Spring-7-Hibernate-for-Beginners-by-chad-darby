package com.practise.jpa.mapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.practise.jpa.mapping.dao.AppDao;
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
			deleteInstructorById(appDao);
			//getInstructor(appDao);
			// createInstructor(appDao);
		};
	}

	private void deleteInstructorById(AppDao appDao) {
		int instructorId = 1;

		 appDao.deleteInstructorById(instructorId);

		
		System.out.println("Delete done !!!");
		
	}

	private void getInstructor(AppDao appDao) {

		int instructorId = 1;

		Instructor data = appDao.getInstructor(instructorId);

		System.out.println(data);
		System.out.println("Instructor Details Data " + data.getInstructorDetails());

	}

	private void createInstructor(AppDao appDao) {

		Instructor instructor = new Instructor("bhaskar", "mudaliyar", "mudaliyar@gmail.com");
		InstructorDetails details = new InstructorDetails("bhaskar@youtube.com", "cricket");

		instructor.setInstructorDetails(details);

		System.out.println("Saving an instructor");
		appDao.save(instructor);
		System.out.println("Done !!!");

	}

}
