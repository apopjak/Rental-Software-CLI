package com.popjak.booking;

import com.popjak.car.CarServices;
import com.popjak.user.UserServices;

import java.util.List;
import java.util.Scanner;

public class BookingServices {
    public static void newBookingRequest(){
        // Method creates new booking requests and exporting them into booking.csv

        Scanner scanner = new Scanner(System.in);

        // Method is going to print all cars and asks user to enter desired car registration number.
        CarServices.showAvailableCars("PETROL");
        CarServices.showAvailableCars("ELECTRIC");
        CarServices.showAvailableCars("HYBRID");

        System.out.print("---------------------------------------------\nEnter Registration number of the car you want to book: ");
        String carSelection = scanner.nextLine().toUpperCase().trim();
        String getCarString = CarServices.getCarInfo(carSelection);
        if (getCarString.startsWith("notFound")) {
            System.out.println("Car booked already or not in database. try again  ❌");
            return;
        }
        // Method asks user to enter which user ID they want to register with
        UserServices.viewAllUsers();
        System.out.println("---------------------------------------------");
        System.out.print("Select userID (uuid long code): ");
        String userSelection = scanner.nextLine().toLowerCase().trim();
        String userString = UserServices.viewAllUsers(userSelection);
        if (userString.startsWith("User")) {
            System.out.println("Incorrect user selected ❌");
            return;
        }

        // NUMBER OF DAYS
        System.out.print("\nEnter number of days u want to register for: ");
        try {
            int numOfDays = scanner.nextInt();
            if (numOfDays <= 0){
                System.out.println("You have entered negative number ❌");
                return;
            }


            List<String> a = List.of(CarServices.getCarInfo(carSelection)
                    .substring(1,CarServices.getCarInfo(carSelection).length() - 1).split(","));
            int carPrice = Integer.parseInt(a.get(5));

            int finalPrice = numOfDays * carPrice;


            // TOTAL BILL PRINTER HERE
            String selection = """
                Your selection:
                ----------------""";
            System.out.println(selection);
            System.out.println(numOfDays + " day(s)\n" + carPrice + "€ per day" +
                    "\nTotal bill: " + finalPrice +
                    "€\nConfirm the selection by typing 'yes': ");

            Scanner s = new Scanner(System.in);
            String confirmation = s.nextLine();

            // IF USER AGREES STRING PRINTED TO booking.CSV
            if (confirmation.equalsIgnoreCase("yes")){
                BookingDAO.exportToCSV(getCarString,userString, numOfDays);
                System.out.println("Car booked successfully! ✅");
            } else {
                System.out.println("Booking canceled ❌");
            }
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input ❌");
        }
    }

}