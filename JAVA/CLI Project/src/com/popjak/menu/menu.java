package com.popjak.menu;
import com.popjak.booking.BookingServices;
import com.popjak.car.CarService;
import com.popjak.user.UserServices;

import java.util.Scanner;

public class Menu {

    public static void mainMenu() {
        // MAIN MENU Method

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
        while (true) {
            System.out.println(mainMenu);
            input = sc.nextLine();
            if (input.equals("0")) break;
            switch (input) {
                case "1" -> BookingServices.newBooking();
                case "2" -> BookingServices.viewUserBookedCars();
                case "3" -> BookingServices.viewAllBookings();
                case "4" -> CarService.showCars("PETROL");
                case "5" -> CarService.showCars("ELECTRIC");
                case "6" -> UserServices.viewAllUsers();
                case "7" -> UserServices.registerUser();
                default -> System.out.println(input + " is not a valid option ❌");
            }
        }
    }
}
