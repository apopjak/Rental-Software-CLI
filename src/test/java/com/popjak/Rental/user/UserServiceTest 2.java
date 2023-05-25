package com.popjak.Rental.user;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    User user;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDAO userDAO;

    @BeforeEach
    void beforeEach() {
        user = new User("Andrej", "Tester", "tester@gmail.com");
        userRepository.save(user);
    }

    @AfterEach
    void afterEach() {
        userRepository.deleteAll();
    }

    /////////////////////////////////////////////////////////////////////////////////////////

    @Test
    void listAllUsers() {
    }

    @Test
    @DisplayName("it should insert user into DB")
    void testInsertToDB() {
        User testUser = new User("Test","New", "Testing@gmail.com");
        userDAO.insertToDB(testUser);
        assertTrue(userRepository.existsByEmail("Testing@gmail.com"));
    }

    @Test
    @DisplayName("It should Test if email exists in DB")
    void checkIfEmailInDB() {
        assertTrue(userDAO.checkIfEmailInDB("tester@gmail.com"));
    }

    @Test
    @DisplayName("User should be removed")
    void removeUserByEmail() {
        User testUser = new User("Andrej", "Popjak", "atest@gmail.com");
        userRepository.save(testUser);
        assertTrue(userRepository.existsByEmail("atest@gmail.com"));

        userDAO.removeUserByEmail("atest@gmail.com");
        assertFalse(userRepository.existsByEmail("atest@gmail.com"));
    }

    @Test
    @DisplayName("it should obtain user by email")
    void getUserByEmail() {
        User testUser = new User("Maros","Popjak","mpopjak@test.com");
        userRepository.save(testUser);
        assertTrue(userRepository.existsByEmail("mpopjak@test.com"));
    }

    @Test
    void userUpdate() {
    }
}