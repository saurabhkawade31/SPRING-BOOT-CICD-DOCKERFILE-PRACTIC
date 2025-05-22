package org.amazon.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for HomeController.
 * 
 * This test class focuses on testing the REST controller
 * endpoints using MockMvc for fast, isolated testing.
 * 
 * @author Lab Student
 * @version 1.0
 */
@WebMvcTest(HomeController.class)
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test the /welcome endpoint returns the correct message.
     */
    @Test
    void getWelcomeMessage_ShouldReturnWelcomeMessage() throws Exception {
        mockMvc.perform(get("/welcome"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome to the Spring Boot REST API!"));
    }

    /**
     * Test the root endpoint returns the correct message.
     */
    @Test
    void home_ShouldReturnHomeMessage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Spring Boot REST API is running! Visit /welcome for the welcome message."));
    }
}
