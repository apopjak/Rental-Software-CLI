package com.popjak.RentalCarCLI.adminMenu;

import com.popjak.RentalCarCLI.user.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class ShowUserByEmail {

    private final UserService userService;

    @Autowired
    public ShowUserByEmail(UserService userService) {
        this.userService = userService;
    }

    public void showUserSelectedByEmail() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------- List of users ---------------------------");
        System.out.print("Enter email address of user you are looking for: ");
        String email = scanner.nextLine().toLowerCase();
        userService.userByEmail(email).forEach(System.out::println);

    }
}
