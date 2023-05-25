package com.popjak.Rental.user.userSubServices;

import com.popjak.Rental.user.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class UserRemove {
    private final UserDAO userDAO;

    public UserRemove(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void userDelete() {
        Scanner scanner = new Scanner(System.in);
        List<User> users = userDAO.listAllUsers();
        users.forEach(System.out::println);

        System.out.print("\nSelect email of the user you want to remove: ");
        String userEmailSelection = scanner.nextLine().toLowerCase().trim();

        if (!userDAO.checkIfEmailInDB(userEmailSelection)) {
            System.out.println("❌ Email not in database");
            return;
        }
        userDAO.removeUserByEmail(userEmailSelection);
        System.out.println("✅ User removed");
    }
}
