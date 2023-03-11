package com.popjak.user;

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
            String uuid = String.valueOf(UUID.randomUUID());
            User user = new User(uuid,input);
            writer.print(user);
            System.out.println("User Created ✅!");

        } catch (IOException e) {
            System.out.println(e.getMessage() + "Car Services");
        }
    }

    public static String viewAllUsers(String uuid) {
        // Method shows all registered users located in users.csv

        // if uuid is Empty (***Empty*** comes from overloaded method bellow)
        List<User> userList = UserDAO.getAllUsers();
        if (uuid.equals("Empty")) {
            for (User user : userList) {
                String detailedView = "Name: " + user.getName() + ", userID: " + user.getUserid();
                System.out.println(detailedView);
            }
        }
        for (int i = 0; i < UserDAO.getAllUsers().size(); i++) {
            if (userList.get(i).getUserid().equalsIgnoreCase(uuid)) {
                return userList.get(i).userString();
            }
        }
        return "User not found";
    }

    public static String viewAllUsers(){
        // Overloaded empty method, which always return whole list.
        viewAllUsers("Empty");
        return null;
    }


    public static String getUserStringForDB(String uuid){
        // Methods returns string ready for exporting to bookingBD

        List<User> userList = UserDAO.getAllUsers();
        for (int i = 0; i < userList.size(); i++) {


            String detailedView = userList.get(i).getUserid() + "," + userList.get(i).getName();
            if (userList.get(i).getUserid().equalsIgnoreCase(uuid)) {
                System.out.println(detailedView);
                return detailedView;
            }
        }
        return "";
    }

}
