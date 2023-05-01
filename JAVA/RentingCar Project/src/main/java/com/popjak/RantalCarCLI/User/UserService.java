package com.popjak.RantalCarCLI.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserJPADataAccessService userJPA;

    @Autowired
    public UserService(UserJPADataAccessService userJPA) {
        this.userJPA = userJPA;
    }

    public void registerUser(User user) {
        if (isEmailInDatabase(user.getEmail())) {
            System.out.println(" >>> Email already registered ❌");
        } else {
            System.out.println(" >>> user Registered ✅");
            userJPA.insertUserIntoDB(user);
        }
    }

    public void showAllUsers() {
        List<User> users = userJPA.showAllUsers();
        users.forEach(System.out::println);
    }

    private boolean isEmailInDatabase(String email) {
        return userJPA.existUserByEmail(email);
    }
}
