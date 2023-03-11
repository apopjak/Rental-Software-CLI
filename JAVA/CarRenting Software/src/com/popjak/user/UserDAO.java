package com.popjak.user;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAO {
    public static File accessToFile() throws IOException {
        File file = new File("src/com/popjak/data/users.csv");
        if (!file.exists()) {
            file.createNewFile();
            return file;
        }
        return file;
    }
    public static List<String> getAllUsers(){
        // Method returns list of users in users.csv.

        List<String> allUsers = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(accessToFile());
            while (scanner.hasNext()) {
                String a = scanner.nextLine();
                allUsers.add(a);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return allUsers;
    }
}
