package com.popjak.CliWithTesting.user.userSubServices;

import com.popjak.CliWithTesting.user.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class ViewAllUsers {
    private final UserDAO userDAO;

    public ViewAllUsers(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void viewAllUsers() {
       List<User> users = userDAO.listAllUsers();
       users.forEach(System.out::println);
    }
}
