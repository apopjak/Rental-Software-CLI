package com.popjak.Rental.menuSelection;

import org.springframework.stereotype.*;

import java.util.*;

@Component
public class AdminMenu {

    private final CarManagement carManagement;
    private final UserManagement userManagement;
    private final BookingManagement bookingManagement;

    public AdminMenu(CarManagement carManagement, UserManagement userManagement, BookingManagement bookingManagement) {
        this.carManagement = carManagement;
        this.userManagement = userManagement;
        this.bookingManagement = bookingManagement;
    }

    public void adminMenu() {

        Scanner scanner = new Scanner(System.in);
        boolean program = true;
        while (program) {

            String message = """
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                          🔸ADMIN MENU            |
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                ☉ 1 —>  Car Management            |
                ☉ 2 —>  User Management           |
                ☉ 3 —>  Booking Management        |
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                ☉ 0 —>  Exit back to Main Menu    |
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                """;

            System.out.println(message);
            String input = scanner.nextLine();

            switch (input) {
                default -> System.out.println("Wrong Input try again ❌");
                case "0" ->{
                    program = false;
                }
                case "1" ->{
                    carManagement.carManagementMenu();
                }
                case "2" ->{
                    userManagement.userManagementMenu();
                }
                case "3" ->{
                    bookingManagement.bookingManagementMenu();
                }
            }
        }
    }
}