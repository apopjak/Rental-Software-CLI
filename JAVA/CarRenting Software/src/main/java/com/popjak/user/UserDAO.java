package com.popjak.user;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAO {
    public static File accessToFile() throws IOException {
        File file = new File("src/main/resources/users.csv");
        if (!file.exists()) {
            file.createNewFile();
            return file;
        }
        return file;
    }
    public static List<User> getAllUsers(){
        // Method returns list of users in users.csv

        List<User> allUsers = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(accessToFile());
            while (scanner.hasNext()) {
                String a = scanner.nextLine();
                List<String> temporaryList = new ArrayList<>(new ArrayList<>(List.of(a.split(","))));
                User user = new User(temporaryList.get(0), temporaryList.get(1));
                allUsers.add(user);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return allUsers;
    }
}
