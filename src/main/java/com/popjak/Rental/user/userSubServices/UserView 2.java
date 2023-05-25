package com.popjak.Rental.user.userSubServices;

import com.popjak.Rental.user.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class UserView {
    private final UserDAO userDAO;

    public UserView(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void viewAllUsers() {
       List<User> users = userDAO.listAllUsers();
       users.forEach(System.out::println);
    }

    public User getUserById(String email) {
        return userDAO.getUserByEmail(email);
    }

    public boolean userExists(String email) {
        return userDAO.checkIfEmailInDB(email);
    }
}
