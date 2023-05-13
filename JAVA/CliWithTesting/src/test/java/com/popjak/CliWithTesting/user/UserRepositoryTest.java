package com.popjak.CliWithTesting.user;

import com.popjak.CliWithTesting.user.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void beforeEach() {
        User user = new User("Andrej", "Popjak", "apopjak@gmail.com");
        userRepository.save(user);
    }

    @AfterEach
    void afterEach() {
        userRepository.deleteAll();
    }


    @Test
    @DisplayName("Email In DB already")
    void checkEmailExistsInDB() {
        String expectedEmail = "apopjak@gmail.com";
        assertTrue(userRepository.existsByEmail(expectedEmail), "Email should be in database");
    }

    @Test
    @DisplayName("Email not in DB")
    void emailShouldNotBeInDB() {
        String expectedEmail = "rara@gmail.com";
        assertFalse(userRepository.existsByEmail(expectedEmail), "Email should not be in database");
    }

}