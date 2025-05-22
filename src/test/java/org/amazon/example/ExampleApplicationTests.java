package org.amazon.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * Integration tests for the ExampleApplication.
 * 
 * This test class verifies that the Spring Boot application
 * context loads successfully without any configuration issues.
 * 
 * @author Lab Student
 * @version 1.0
 */
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ExampleApplicationTests {

	/**
	 * Test that verifies the application context loads successfully.
	 * 
	 * This is a basic smoke test that ensures the application
	 * can start up without throwing any exceptions.
	 */
	@Test
	void contextLoads() {
		// This test will pass if the application context loads successfully
		// No additional assertions needed for this basic test
	}
}