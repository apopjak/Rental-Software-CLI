package com.popjak.Rental.user.userSubServices;

import com.popjak.Rental.user.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class UserUpdate {

    private final UserDAO userDAO;

    public UserUpdate(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void userUpdate() {

        Scanner scanner = new Scanner(System.in);
        List<User> users = userDAO.listAllUsers();
        users.forEach(System.out::println);

        System.out.print("Select email of the user you want to update: ");

        var userEmailSelection = scanner.nextLine().toLowerCase().trim();
        if (userEmailSelection.isEmpty()) return;

        User oldUser = userDAO.getUserByEmail(userEmailSelection);

        if (!userDAO.checkIfEmailInDB(userEmailSelection)) { System.out.println("❌ This Email not registered"); return;}

        System.out.print("Updated first name: ");
        String newFirstName = scanner.nextLine().toUpperCase().trim();
        if (newFirstName.isEmpty()) {System.out.println("First name cannot be blank");return;}

        System.out.print("Updated last name: ");
        String newLastName = scanner.nextLine().toUpperCase().trim();
        if (newLastName.isEmpty()) {System.out.println("Last name cannot be blank"); return;}

        System.out.print("Updated Email: ");
        String newEmailAddress = scanner.nextLine().toLowerCase().trim();

        if (!newEmailAddress.equals(oldUser.getEmail()) & userDAO.checkIfEmailInDB(newEmailAddress)) {
            System.out.println("❌ Email used by other user");
            return;
        }

        System.out.print("Entered details\n-----------------------\n" +
                "First name: " + newFirstName +
                "\nLast name: " + newLastName +
                "\nEmail address: " + newEmailAddress +
                "\n-----------------------\n" +
                "Would you like to continue? 'yes' or 'no' : ");

        String confirmation = scanner.nextLine();
        if (confirmation.substring(0, 1).equalsIgnoreCase("y")) {
            userDAO.userUpdate(userEmailSelection, newFirstName, newLastName, newEmailAddress);
        } else {
            System.out.println("❌ User NOT registered");
        }
    }
}

