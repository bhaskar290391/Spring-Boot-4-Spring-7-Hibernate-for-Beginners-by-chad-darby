package com.practise.jpa.hibernate;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.practise.jpa.hibernate.dao.StudentDao;
import com.practise.jpa.hibernate.entity.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandlineRunner(StudentDao repo) {
		return runner -> {

			deleteStudents(repo);
			// findByLastName(repo);
			// update(repo);
			// readAllTheStudentsFromSystem(repo);

			// readStudentById(repo);
			// createMultipleStudents(repo);
		};
	}

	private void deleteStudents(StudentDao repo) {
		int stududentId=3;
		
		repo.delete(stududentId);
	}

	private void findByLastName(StudentDao repo) {

		String lastName = "Shetty";

		System.out.println(repo.findByLastName(lastName));
	}

	private void update(StudentDao repo) {
		int studentId = 2;

		Student student = repo.findById(studentId);

		student.setLastName("Shetty");

		Student updateStudnets = repo.update(student);

		System.out.println(updateStudnets);

	}

	private void readAllTheStudentsFromSystem(StudentDao repo) {

		List<Student> students = repo.findAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudentById(StudentDao repo) {

		int studentId = 1;

		Student student = repo.findById(studentId);
		System.out.println(student);
	}

	private void createMultipleStudents(StudentDao repo) {
		Student s = new Student("Bhaskar", "Mudaliyar", "bhaksar@gmail.com");
		Student s1 = new Student("Kanishk", "Mudaliyar", "bhaksar@gmail.com");
		Student s2 = new Student("Sammy", "Mudaliyar", "bhaksar@gmail.com");

		repo.save(s);
		repo.save(s1);
		repo.save(s2);
	}

}
