package com.popjak.CliWithTesting.user.userSubServices;

import com.popjak.CliWithTesting.user.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class ViewUsers {
    private final UserDAO userDAO;

    public ViewUsers(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void viewAllUsers() {
       List<User> users = userDAO.listAllUsers();
       users.forEach(System.out::println);
    }

    public User selectUserById(String email) {
        return userDAO.selectUserByEmail(email);
    }

    public boolean userExists(String email) {
        return userDAO.emailExistsInDbAlready(email);
    }
}
