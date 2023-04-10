package com.popjak.user;

import com.github.javafaker.Faker;

import java.util.Scanner;

public class UserServices{


    private static UserDAO userDAO;

    public UserServices(UserDAO userDAO) {
        UserServices.userDAO = userDAO;
    }

    static Scanner scanner = new Scanner(System.in);
    public void registerUser() {
        // Registration of new user

        System.out.print("Name of the user: ");
        String input = scanner.next().trim();
        Faker faker = new Faker();
        User user = new User(faker.idNumber().ssnValid(),input);
        userDAO.addToCSV(user);
    }


    public String viewAllUsers(String uuid) {

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

    public String viewAllUsers(){
        // Overloaded empty method, which always return whole list.
        viewAllUsers("Empty");
        return null;
    }
}
