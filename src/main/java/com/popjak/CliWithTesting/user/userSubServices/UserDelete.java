package com.popjak.CliWithTesting.user.userSubServices;

import com.popjak.CliWithTesting.user.*;
import org.springframework.stereotype.*;

import java.util.*;

import static com.popjak.CliWithTesting.util.StringIntegerChecker.*;

@Component
public class UserDelete {
    private final UserDAO userDAO;

    public UserDelete(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void userDelete() {
        Scanner scanner = new Scanner(System.in);
        List<User> users = userDAO.listAllUsers();
        users.forEach(System.out::println);

        System.out.print("\nSelect ID of the user you want to remove: ");
        String input = stringIntegerChecker(scanner.nextLine());
        if (input == null) return;
        Integer Id = Integer.parseInt(input);

        if (userDAO.removeUserById(Id) == 1) {
            System.out.println("✅ User removed from DB");
        }
    }
}
