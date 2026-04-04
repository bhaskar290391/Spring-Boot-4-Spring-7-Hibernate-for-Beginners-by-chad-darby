package com.practise.springboot.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.springboot.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World ";
	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		List<Student> data = new ArrayList<>();
		data.add(new Student("Bhaskar", "Mudaliyar"));
		data.add(new Student("Kanishk", "Soni"));
		data.add(new Student("Soni ", "BHaskar"));

		return data;
	}
}
