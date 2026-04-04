package com.practise.springboot.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.springboot.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentController {

	private List<Student> data;

	@PostConstruct
	public void constructData() {
		data = new ArrayList<>();
		data.add(new Student("Bhaskar", "Mudaliyar"));
		data.add(new Student("Kanishk", "Soni"));
		data.add(new Student("Soni ", "BHaskar"));
	}

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World ";
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return data;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudentData(@PathVariable int studentId) {
		return data.get(studentId);
	}
}
