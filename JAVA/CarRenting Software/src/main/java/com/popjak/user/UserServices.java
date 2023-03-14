package com.popjak.user;

import com.github.javafaker.Faker;

import java.util.Scanner;

public class UserServices{

    static UserDAO userDAO = new UserDAO();
    static Scanner scanner = new Scanner(System.in);
    public static void registerUser() {
        // Registration of new user

        System.out.print("Name of the user: ");
        String input = scanner.next().trim();
        Faker faker = new Faker();
        User user = new User(faker.idNumber().ssnValid(),input);
        userDAO.addToCSV(user);
    }


    public static String viewAllUsers(String uuid) {

        // if uuid is Empty (***Empty*** comes from overloaded method bellow)

        for (User user : userDAO.getList()) {
            if (user.getUserid().equalsIgnoreCase(uuid)) {
                return user.userString();
            } else if (uuid.equals("Empty")) {
                String detailedView = "Name: " + user.getName() + ", userID: " + user.getUserid();
                System.out.println(user.fullString());
            }
        }
        return "User not found";
    }

    public static String viewAllUsers(){
        // Overloaded empty method, which always return whole list.
        viewAllUsers("Empty");
        return null;
    }
}
