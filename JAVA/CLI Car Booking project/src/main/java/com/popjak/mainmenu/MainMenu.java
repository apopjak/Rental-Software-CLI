package com.popjak.mainmenu;

import com.popjak.booking.BookingServices;
import com.popjak.car.CarServices;
import com.popjak.user.UserServices;

import java.util.Scanner;

public class MainMenu {
    private final CarServices carServices;
    private final BookingServices bookingServices;
    private final UserServices userServices;

    public MainMenu(CarServices carServices, BookingServices bookingServices, UserServices userServices) {
        this.carServices = carServices;
        this.bookingServices = bookingServices;
        this.userServices = userServices;
    }


    public void mainMenu(){


        String input;
        String mainMenu = """

                1️⃣ - Book Car
                2️⃣ - View All User Booked Cars
                3️⃣ - View All Bookings
                4️⃣ - View Available Petrol Cars
                5️⃣ - View Available Electric Cars
                6️⃣ - View Available Hybrid Cars
                7️⃣ - View All users
                8️⃣ - Register new user

                0️⃣ - Exit
                """;

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(mainMenu);
            input = sc.nextLine();
            if (input.equals("0")) break;
            switch (input) {
                case "1" -> bookingServices.newBookingRequest();
                case "2" -> bookingServices.viewUserBookings();
                case "3" -> bookingServices.viewAllBookings();
                case "4" -> carServices.showAvailableCars("PETROL", "none", "none");
                case "5" -> carServices.showAvailableCars("none", "ELECTRIC", "none");
                case "6" -> carServices.showAvailableCars("none", "none", "HYBRID");
                case "7" -> userServices.viewAllUsers("ALL");
                case "8" -> userServices.registerUser();

                default -> System.out.println(input + " is not a valid option ❌");
            }
        }
    }

}
