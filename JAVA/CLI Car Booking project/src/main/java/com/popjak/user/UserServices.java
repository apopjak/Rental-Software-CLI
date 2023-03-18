package com.popjak.user;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UserServices{

    private static UserDAO userDAO;

    public UserServices(UserDAO userDAO) {
        UserServices.userDAO = userDAO;
    }

    public void registerUser() {
        // Registration of new user

        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of the user: ");
        String input = scanner.next().trim();
        Faker faker = new Faker();
        User user = new User(faker.idNumber().ssnValid(),input);

        if (!viewAllUsers(input).startsWith("User")) {
            System.out.println("User name registered, choose different name ❌");
            return;
        }
        userDAO.addToCSV(user);

    }

    public String viewAllUsers(String userName) {

        for (User user : userDAO.selectAllUsers()) {
            if (user.getName().equalsIgnoreCase(userName)) {
                return user.userString();
            } else if (userName.equals("ALL")) {
                System.out.println(user.fullString());
            }
        }
        return "User not found";
    }
}
