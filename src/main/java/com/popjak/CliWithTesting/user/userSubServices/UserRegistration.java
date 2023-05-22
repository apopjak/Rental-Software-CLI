package com.popjak.CliWithTesting.user.userSubServices;

import com.popjak.CliWithTesting.user.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class UserRegistration {
    private final UserDAO userDAO;

    public UserRegistration(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public void userRegistration() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("First Name: ");
        String firstName = scanner.nextLine().toUpperCase().trim();
        if (firstName.isEmpty()) {System.out.println("First name cannot be blank");return;}

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine().toUpperCase().trim();
        if (lastName.isEmpty()) {System.out.println("Last name cannot be blank"); return;}

        System.out.print("Email: ");
        String email = scanner.nextLine().toLowerCase().trim();
        if (email.isEmpty()) { System.out.println("First name cannot be blank"); return;}
        if (userDAO.emailExistsInDbAlready(email)) {
            System.out.println("❌ This email already registered");
            return;
        }

        System.out.print("Entered details\n-----------------------\n" +
                "First name: " + firstName +
                "\nLast name: " + lastName +
                "\nEmail address: " + email +
                "\n-----------------------\n" +
                "Would you like to continue? 'yes' or 'no' : ");

        String confirmation = scanner.nextLine();
        if (confirmation.substring(0, 1).equalsIgnoreCase("y")) {
            User user = new User(firstName, lastName, email);
            userDAO.insertToDB(user);
            System.out.println("✅ User registered ");
        } else {
            System.out.println("❌ User NOT registered");
        }
    }
}
