package com.management.org.student_coach_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * Main entrypoint for the Student Coach Management Spring Boot application.
 * Runs the embedded server and bootstraps the Spring application context.
 */
public class StudentCoachManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCoachManagementApplication.class, args);
	}


}
