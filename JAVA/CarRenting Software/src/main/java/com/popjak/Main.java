package com.popjak;

import com.popjak.booking.BookingServices;
import com.popjak.car.CarServices;
import com.popjak.user.UserServices;

import java.util.Scanner;


public class Main {
    public static void main(String[] args){

        mainMenu();








    }
    public static void mainMenu(){
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
                case "1" -> BookingServices.newBookingRequest();
                case "2" -> BookingServices.viewUserBookings();
                case "3" -> BookingServices.viewAllBookings();
                case "4" -> CarServices.showAvailableCars("PETROL");
                case "5" -> CarServices.showAvailableCars("ELECTRIC");
                case "6" -> CarServices.showAvailableCars("HYBRID");
                case "7" -> UserServices.viewAllUsers();
                case "8" -> UserServices.registerUser();

                default -> System.out.println(input + " is not a valid option ❌");
            }
        }
    }
}