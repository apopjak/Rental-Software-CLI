package com.popjak.RentalCarCLI.mainMenu;

import com.popjak.RentalCarCLI.car.*;
import com.popjak.RentalCarCLI.user.*;

import java.util.*;

public class BookCar {

    private final UserService userService;
    private final CarService carService;

    public BookCar(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
    }


    public void newBooking() {
        Scanner scanner = new Scanner(System.in);
        // 1. ask for email
        // 2. validate email, if email exists continue if not error message
        // 3. from what price range car user wants to pick
        // 4. show all cars in that price range which are available
        // if car already in booking DB do not show it
        // 5. ask how many days rent is for
        // 6. show final price including deposit
        // add to database

        // ask for email
        System.out.println("Renting Software\n\n");
        System.out.print("Enter your userID (registered email address): ");
        String email = scanner.nextLine().toLowerCase();

        // if not in DB exit out of the newBooking() Methods
        if (!userService.isEmailInDatabase(email)) {
            System.out.println("❌ Email not Registered. Please register first");
            return;
        }


        // List all CARS and make a selection
        carService.showAllCars();
        System.out.println("\n Select ID of the car you want to book");




    }
}
