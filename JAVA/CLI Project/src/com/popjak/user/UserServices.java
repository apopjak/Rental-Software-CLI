package com.popjak.user;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServices {

    public static void registerUser(){
        // User Registration Method. Adds user to userDatabase.csv

        try(
                // closable flushable
                FileWriter fileWriter = new FileWriter(UserDAO.getAccessToFile(),true);
                PrintWriter writter = new PrintWriter(fileWriter);
        ){
            // if car is not in database then add it
            Scanner scanner = new Scanner(System.in);
            System.out.print("Vlozte meno (vsetko spolu): ");
            String input = scanner.next().trim();
            User user = new User(input);
            writter.print(user);
            System.out.println("Uzivatel vytvoreny!");

        } catch (IOException e) {
            System.out.println(e.getMessage() + "Car Services");
        }
    }

    public static void viewAllUsers(){
        // Method filter all users in database and print them to user!

        System.out.println("Zoznam uzivatelov: \n-----------------------\n");
        try{
            Scanner s = new Scanner(UserDAO.getAccessToFile());
            while (s.hasNext()) {

                // converting CSV to list and analyzing if car exists in the list.
                List<String> list = new ArrayList<>(List.of(s.nextLine().split(",")));
                String detailedView = "ID: " + list.get(0) + " Meno: " + list.get(1);
                System.out.println(detailedView);
            }
        } catch (IOException e ){
            System.out.println(e.getMessage());
        }
    }
    private static boolean userExists(String uuid){
        // Returns true if user exists

        try{
            Scanner s = new Scanner(UserDAO.getAccessToFile());
            while (s.hasNext()) {

                // converting CSV to list and analyzing if car exists in the list.
                List<String> list = new ArrayList<>(List.of(s.nextLine().split(",")));
                if (uuid.equals(list.get(0))) {
                    return true;
                }
            }
        } catch (IOException e ){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public static String getUserString(String uuid) {
        // Method return string of the user for booking database

        if (userExists(uuid)) {
            try{
                Scanner s = new Scanner(UserDAO.getAccessToFile());
                while (s.hasNext()) {

                    // converting CSV to list and analyzing if car exists in the list.
                    List<String> list = new ArrayList<>(List.of(s.nextLine().split(",")));
                    if (uuid.equals(list.get(0))) {
                        return list.get(0) + "," + list.get(1);
                    }
                }
            } catch (IOException e ){
                System.out.println(e.getMessage());
            }

        }
        return "NULL";
    }

}
