package org.amazon.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Application class.
 * 
 * This class serves as the entry point for the Spring Boot application.
 * The @SpringBootApplication annotation enables auto-configuration, 
 * component scanning, and configuration properties.
 * 
 * @author Lab Student
 * @version 1.0
 */
@SpringBootApplication
public class ExampleApplication {

	/**
	 * Main method to start the Spring Boot application.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}
}