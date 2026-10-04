package org.amazon.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for handling HTTP requests.
 * 
 * This controller provides endpoints for the REST API.
 * The @RestController annotation combines @Controller and @ResponseBody,
 * meaning that data returned by each method will be written straight 
 * into the response body instead of rendering a template.
 * 
 * @author Lab Student
 * @version 1.0
 */
@RestController
public class HomeController {

    /**
     * Welcome endpoint that returns a greeting message.
     * 
     * This method handles GET requests to the "/welcome" path.
     * It returns a simple string message that will be displayed
     * in the HTTP response body.
     * 
     * @return A welcome message string
     */
    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        return "Welcome to the Spring Boot REST API!";
    }
    
    /**
     * Root endpoint for basic health check.
     * 
     * @return A simple status message
     */
    @GetMapping("/")
    public String home() {
        return "Spring Boot REST API is running! Visit /Welcome to devops practic nd cicd pipeline.";
    }
}
