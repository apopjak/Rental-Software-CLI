package com.popjak.RentalCarCLI.user;

import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UserService {

    private final UserJPADataAccessService userJpa;

    public UserService(UserJPADataAccessService userJpa) {
        this.userJpa = userJpa;
    }


    public void registerUser(User user) {
        if (isEmailInDatabase(user.getEmail())) {
            System.out.println(" >>> Email already registered ❌");
        } else {
            System.out.println(" >>> user Registered ✅");
            userJpa.insertUserIntoDB(user);
        }
    }

    public List<User> listOFUsers() {
        return userJpa.showAllUsers();

    }

    private boolean isEmailInDatabase(String email) {
        return userJpa.existUserByEmail(email);
    }

    public List<User> userByEmail(String email) {

        if (isEmailInDatabase(email)) {
            return userJpa.findUserByEmail(email);
        } else {
            System.out.println("Email not in Database ❌");
            return userJpa.findUserByEmail(email);
        }

    }
}
