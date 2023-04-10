package com.popjak.user;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Repository
public class UserDataAccessService implements UserDAO{

    static String PATH = "src/main/resources/users.csv";

    @Override
    public File accessToFile(String path) throws IOException {
        File file = new File(PATH);
        if (!file.exists()) {
            file.createNewFile();
            return file;
        }
        return file;
    }

    @Override
    public List<User> selectAllUsers() {
        // Method returns list of all users.

        List<User> allUsers = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(accessToFile(PATH));
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

    @Override
    public void addToCSV(User user) {
        try(
                // closable flushable
                FileWriter fileWriter = new FileWriter(accessToFile(PATH),true);
                PrintWriter writer = new PrintWriter(fileWriter)
        ){

            writer.print(user);
            System.out.println("User registered ✅");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
