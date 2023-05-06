package com.popjak.RentalCarCLI.mainMenu;

import com.popjak.RentalCarCLI.user.*;
import com.popjak.RentalCarCLI.utils.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class RegisterUser {

    private final UserService userService;

    @Autowired
    public RegisterUser(UserService userService) {
        this.userService = userService;
    }


    public void registerNewUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------- user registration ----------------------");


        System.out.print("First name: ");
        String firstName = ToTitleCaseString.titleCase(scanner.nextLine());

        System.out.print("Last name: ");
        String lastName = ToTitleCaseString.titleCase(scanner.nextLine());

        System.out.print("Email address: ");
        String email = scanner.nextLine().toLowerCase();
        if (!email.contains("@")) {
            System.out.println(" >>> Wrong email format ❌");
        } else {
            User user = new User(firstName, lastName, email);
            userService.registerUser(user);
        }
    }
}

