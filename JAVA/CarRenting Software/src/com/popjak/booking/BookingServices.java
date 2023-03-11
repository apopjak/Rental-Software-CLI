package com.popjak.booking;

import com.popjak.car.CarServices;
import com.popjak.user.UserServices;

import java.math.BigDecimal;
import java.util.Scanner;

public class BookingServices {


    public static void newBookingRequest() {
        Scanner s = new Scanner(System.in);


        // Method is going to print all cars and asks user to enter desired car registration number.
        CarServices.showAvailableCars("ALL");
        System.out.println("---------------------------------------------");
        System.out.print("Enter Registration number of the car you want to book: ");
        String carSelection = s.nextLine().toUpperCase().trim(); // ask user to enter car number
        String getCarString = CarServices.getCarInfo(carSelection);
        if (getCarString.startsWith("This")) {
            System.out.println("Car booked already or not in database. try again  ❌");
            return;
        }

        // Method asks user to enter which user ID they want to register with
        UserServices.viewAllUsers();
        System.out.println("---------------------------------------------");
        System.out.print("Select userID (uuid long code): ");
        String userSelection = s.nextLine().toLowerCase().trim();
        String viewUser = UserServices.viewAllUsers(userSelection);
        if (getCarString.startsWith("User")) {
            System.out.println("Incorrect userID  ❌");
        } else {
            System.out.print("\nEnter number of days u want to register for: ");
            BigDecimal numOfDays = new BigDecimal(s.nextLine().trim());
            BigDecimal getCarPrice = CarServices.getPrice(carSelection);
            BigDecimal finalPrice = numOfDays.multiply(getCarPrice);

            String selection = """
                        Your selection:
                        ----------------""";
            System.out.println(selection);
            System.out.println(numOfDays + " day(s)\n" + getCarPrice + "€ per day" +
                    "\nTotal bill: " + finalPrice +
                    "€\nConfirm the selection by typing 'yes': ");

            String confirmation = s.nextLine().toUpperCase().trim();

            // Method asks user if he agrees to final bill, if YES it print the message
            // and adds the car into bookings.csv file as a reference
            if (confirmation.charAt(0) == 'Y'){
                BookingDAO.exportToCSV(carSelection,userSelection,Integer.parseInt(String.valueOf(numOfDays)));
                System.out.println("Car booked successfully! ✅");
            } else {
                System.out.println("Booking canceled ❌");
            }
        }
    }


}
