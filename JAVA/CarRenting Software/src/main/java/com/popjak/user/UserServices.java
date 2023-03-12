package com.popjak.user;

import com.github.javafaker.Faker;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class UserServices {
    public static void registerUser(){
        // User Registration Method Adds user to userDatabase.csv

        try(
                // closable flushable
                FileWriter fileWriter = new FileWriter(UserDAO.accessToFile(),true);
                PrintWriter writer = new PrintWriter(fileWriter);
        ){
            // Registration of new user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Name of the user: ");
            String input = scanner.next().trim();
            Faker faker = new Faker();
            User user = new User(faker.idNumber().ssnValid(),input);
            writer.print(user);
            System.out.println("User Created ✅!");

        } catch (IOException e) {
            System.out.println(e.getMessage() + "Car Services");
        }
    }

    public static String viewAllUsers(String uuid) {

        // if uuid is Empty (***Empty*** comes from overloaded method bellow)
        List<User> userList = UserDAO.getAllUsers();
        for (User user : userList) {
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
