package com.popjak.Rental.menuSelection;

import org.springframework.stereotype.*;

import java.util.*;

import static com.popjak.Rental.util.ScreenCleaner.screenCleaner;

@Component
public class BookingManagement {

    public void bookingManagementMenu() {

        Scanner scanner = new Scanner(System.in);
        boolean program = true;
        while (program) {

            String message = """
            =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
            >>>> 🔸 BOOKING MANAGEMENT CONSOLE 🔸<<<<  |
            =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
            ☉ 1 —>  Show all bookings                  |
            ☉ 2 —>  Cancel booking                     |
            =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
            ☉ 8 —>  Admin MENU                         |
            ☉ 9 —>  Main MENU                          |
            ☉ 0 —>  Exit                               |
            =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
            """;

            System.out.println(message);
            String input = scanner.nextLine();

            switch (input) {
                default -> System.out.println("Wrong Input try again ❌");
                case "0" ->{
                    program = false;
                }
                case "1" ->{
                    screenCleaner();
                    System.out.println("================= Rent a car =================");

                }
                case "2" ->{
                    screenCleaner();
                    System.out.println("--------- View available cars -------------------------------------\n");

                    // TODO: create extramenu for this input

                }
                case "3" ->{
                    screenCleaner();
                    System.out.println("--------- Register new user account -------------------------------------\n");

                }
                case "9" ->{
                    screenCleaner();
                    System.out.println("--------- ADMIN MENU -------------------------------------\n");

                    //TODO: create extramenu for this input
                }
            }
        }
    }
}
