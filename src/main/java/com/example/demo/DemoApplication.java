package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// Start the Spring Boot application context
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		// Get the StudentService bean
		StudentService studentService = context.getBean(StudentService.class);

		// 1. Add new students
		Student student1 = new Student();
		student1.setName("John Doe");
		student1.setEmail("john.doe@example.com");
		student1.setAge(18L);
		Student savedStudent1 = studentService.saveStudent(student1);
		System.out.println("Added Student: " + savedStudent1);

		Student student2 = new Student();
		student2.setName("Jane Smith");
		student2.setEmail("jane.smith@example.com");
		student2.setAge(21L);
		Student savedStudent2 = studentService.saveStudent(student2);
		System.out.println("Added Student: " + savedStudent2);

		// 2. Retrieve and print all students
		System.out.println("All Students: " + studentService.getAllStudents());

		// 3. Update a student
		Student updateStudent = new Student();
		updateStudent.setName("John Updated");
		updateStudent.setEmail("john.updated@example.com");
		updateStudent.setAge(25L);
		Student updatedStudent = studentService.updateStudent(savedStudent1.getId(), updateStudent);
		System.out.println("Updated Student: " + updatedStudent);

		// 4. Delete a student
		studentService.deleteStudent(savedStudent2.getId());
		System.out.println("Deleted Student with ID: " + savedStudent2.getId());

		// 5. Print all students after deletion
		System.out.println("All Students after Deletion: " + studentService.getAllStudents());
	}
}