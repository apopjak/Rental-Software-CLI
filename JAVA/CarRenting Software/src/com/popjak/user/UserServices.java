package com.popjak.user;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class UserServices {
    public static void registerUser(){
        // User Registration Method. Adds user to userDatabase.csv

        try(
                // closable flushable
                FileWriter fileWriter = new FileWriter(UserDAO.accessToFile(),true);
                PrintWriter writer = new PrintWriter(fileWriter);
        ){
            // if car is not in database then add it
            Scanner scanner = new Scanner(System.in);
            System.out.print("Name of the user: ");
            String input = scanner.next().trim();
            User user = new User(input);
            writer.print(user);
            System.out.println("User Created ✅!");

        } catch (IOException e) {
            System.out.println(e.getMessage() + "Car Services");
        }
    }

    public static String viewAllUsers(String uuid) {
        // Method shows all registered users located in users.csv

        // if uuid is Empty (***Empty*** comes from overloaded method bellow)
        if (uuid.equals("Empty")) {
            for (int i = 0; i < UserDAO.getAllUsers().size(); i++) {
                List<String> temporaryList = List.of(UserDAO.getAllUsers().get(i).split(","));
                String detailedView = "Name: " + temporaryList.get(1) + ", userID: " + temporaryList.get(0);
                System.out.println(detailedView);
            }
            return "";
        }
        for (int i = 0; i < UserDAO.getAllUsers().size(); i++) {
            List<String> temporaryList = List.of(UserDAO.getAllUsers().get(i).split(","));
            String detailedView = "Name: " + temporaryList.get(1) + ", userID: " + temporaryList.get(0);
            if (temporaryList.get(0).equals(uuid)) {
                System.out.println(detailedView);
                return detailedView;
            }
        }
        System.out.println("User not found try again ❌");
        return "User not found try again ❌";
    }

    public static void viewAllUsers(){
        // Overloaded empty method, which always return whole list.
        viewAllUsers("Empty");
    }


    public static String getUserStringForDB(String uuid){
        // Methods returns string ready for exporting to bookingBD

        for (int i = 0; i < UserDAO.getAllUsers().size(); i++) {

            List<String> temporaryList = List.of(UserDAO.getAllUsers().get(i).split(","));
            String detailedView = temporaryList.get(1) + "," + temporaryList.get(0);
            if (temporaryList.get(0).equals(uuid)) {
                System.out.println(detailedView);
                return detailedView;
            }
        }
        return "";
    }

}
