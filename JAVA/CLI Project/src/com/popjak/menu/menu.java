package com.popjak.menu;

import com.popjak.car.CarService;
import com.popjak.user.UserServices;

import java.util.Scanner;

public class Menu {

    public static void mainMenu() {
        // Main Menu, while loop
        String input;
        String mainMenu = """
                
                1️⃣ - Book Car
                2️⃣ - View All User Booked Cars
                3️⃣ - View All Bookings
                4️⃣ - View Available Regular Cars
                5️⃣ - View Available Electric Cars
                6️⃣ - View All users                
                7️⃣ - Register new user
                
                0️⃣ - Exit
                """;

        Scanner sc = new Scanner(System.in);
        // TODO: add switch statement here to control the menu
        while (true) {
            System.out.println(mainMenu);
            input = sc.nextLine();
            if (input.equals("0")) break;
            switch (input) {
                case "1" -> System.out.println("1");
                case "2" -> System.out.println("2");
                case "3" -> System.out.println("3");
                case "4" -> CarService.carLoopUpPETROL();
                case "5" -> CarService.carLoopUpELECTRIC();
                case "6" -> UserServices.viewAllUsers();
                case "7" -> UserServices.registerUser();

                default -> System.out.println(input + " is not a valid option ❌");
            }
        }
    }
}
