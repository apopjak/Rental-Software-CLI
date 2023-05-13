package com.popjak.CliWithTesting.user.userSubServices;

import com.popjak.CliWithTesting.user.*;
import static com.popjak.CliWithTesting.util.StringIntegerChecker.stringIntegerChecker;
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

        System.out.print("Select ID of the user you want to update: ");

        var input = stringIntegerChecker(scanner.nextLine());
        if (input == null) return;
        Integer Id = Integer.parseInt(input);
        User oldUser = userDAO.findUserById(Id);


        if (!userDAO.existsById(Id)) { System.out.println("❌ This ID is not in the system"); return;}

        System.out.print("First Name: ");
        String firstName = scanner.nextLine().toUpperCase().trim();
        if (firstName.isEmpty()) {System.out.println("First name cannot be blank");return;}

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine().toUpperCase().trim();
        if (lastName.isEmpty()) {System.out.println("Last name cannot be blank"); return;}

        System.out.print("Email: ");
        String email_address = scanner.nextLine().toLowerCase().trim();

        // IF email is NOT the same AND it is already in database
        // if email is the same as the old one we want to continue just fine
        if (!email_address.equals(oldUser.getEmail()) & userDAO.emailExistsInDbAlready(email_address)) {
            System.out.println("❌ Email used by other user");
            return;
        }

        System.out.print("Entered details\n-----------------------\n" +
                "First name: " + firstName +
                "\nLast name: " + lastName +
                "\nEmail address: " + email_address +
                "\n-----------------------\n" +
                "Would you like to continue? 'yes' or 'no' : ");

        String confirmation = scanner.nextLine();
        if (confirmation.substring(0, 1).equalsIgnoreCase("y")) {
            User user = new User(firstName, lastName, email_address);
            userDAO.insertToDB(user);
            System.out.println("✅ User registered ");
            userDAO.removeUserById(Id);
        } else {
            System.out.println("❌ User NOT registered");
        }
    }
}

