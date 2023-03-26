package com.popjak.user;

import com.popjak.DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAO implements DAO<User>{

    static final String PATH = "src/main/resources/users.csv";

    @Override
    public List<User> getList() {
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

    public void addToCSV(User user) {
        try(
                // closable flushable
                FileWriter fileWriter = new FileWriter(accessToFile(PATH),true);
                PrintWriter writer = new PrintWriter(fileWriter)
        ){
            writer.print(user);
            System.out.println("CUSTOM");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}



