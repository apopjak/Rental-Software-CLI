package com.popjak.Rental.menuSelection;

import com.popjak.Rental.user.userSubServices.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class UserManagement {

    private static final Scanner scanner = new Scanner(System.in);

    private final UserView userView;
    private final UserRegistration userRegistration;
    private final UserUpdate userUpdate;
    private final UserRemove userRemove;

    public UserManagement(UserView userView, UserRegistration userRegistration, UserUpdate userUpdate, UserRemove userRemove) {
        this.userView = userView;
        this.userRegistration = userRegistration;
        this.userUpdate = userUpdate;
        this.userRemove = userRemove;
    }


    public void userManagementMenu() {

        boolean program = true;
        while (program) {

            String message = """
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                    >>>>> 🔸 USER MANAGEMENT CONSOLE 🔸<<<<<  |
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                    ☉ 1 —>  Show all users                    |
                    ☉ 2 —>  Add user                          |
                    ☉ 3 —>  Update user                       |
                    ☉ 4 —>  Remove user                       |
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                    ☉ 0 —>  Exit to Admin Menu                |
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                    """;

            System.out.println(message);
            String input = scanner.nextLine();

            switch (input) {
                default -> System.out.println("Wrong Input try again ❌");
                case "0" ->{
                    program = false;
                }
                case "1" ->{
                    System.out.println("================= Show All Users =================");
                    userView.viewAllUsers();
                }
                case "2" ->{
                    System.out.println("================= User Registration =================");
                    userRegistration.userRegistration();
                }
                case "3" ->{
                    System.out.println("================= User Update =================");
                    userUpdate.userUpdate();
                }
                case "4" ->{
                    System.out.println("================= User Remove =================");
                    userRemove.userDelete();
                }
            }
        }
    }
}
