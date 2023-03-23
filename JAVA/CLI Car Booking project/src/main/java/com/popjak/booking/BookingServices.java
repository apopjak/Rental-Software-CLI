package com.popjak.booking;

import com.popjak.car.CarServices;
import com.popjak.user.User;
import com.popjak.user.UserServices;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class BookingServices {

    private final BookingDAO bookingDAO;
    private final CarServices carServices;
    private final UserServices userServices;

    public BookingServices(BookingDAO bookingDAO, CarServices carServices, UserServices userServices) {
        this.bookingDAO = bookingDAO;
        this.carServices = carServices;
        this.userServices = userServices;
    }

    public void newBookingRequest() {
        Scanner scanner = new Scanner(System.in);

        // SHOWS ALL CARS
        carServices.showAvailableCars("PETROL","ELECTRIC", "HYBRID");

        // Ask user to pick the car!
        System.out.print("---------------------------------------------\n ➡️ Enter Registration number of the car you want to book: ");
        String SPZ = scanner.nextLine().toUpperCase().trim();
        String getCarString = carServices.getCarInfo(SPZ);
        if (carServices.getCarInfo(SPZ).isEmpty()) {
            System.out.println("incorrect registration number entered  ❌");
            return;
        }

        // Method asks user to enter which user ID they want to register with
        userServices.viewAllUsers("ALL");
        System.out.println("---------------------------------------------");
        System.out.printf(" ➡️ Select USER NAME of the user you want to book %s for: ".formatted(SPZ));
        String userSelection = scanner.nextLine().toLowerCase().trim();
        String userString = userServices.viewAllUsers(userSelection);
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

            List<String> a = List.of(carServices.getCarInfo(SPZ).split(","));
            int carPrice = Integer.parseInt(a.get(a.size() - 1));
            int finalPrice = numOfDays * carPrice;
            System.out.println(carPrice + " car price");
            System.out.println(finalPrice + " final price");


            // TOTAL BILL PRINTER HERE
            String selection = """
                Your selection:
                ----------------""";
            System.out.println(selection);
            System.out.println(numOfDays + " day(s)\n" + carPrice + "€ per day" +
                    "\nTotal bill: " + finalPrice +
                    "€\nConfirm the selection by typing 'yes': ");

            Scanner sc = new Scanner(System.in);
            String confirmation = sc.nextLine().trim();

            // IF USER AGREES STRING PRINTED TO booking.CSV
            if (confirmation.equalsIgnoreCase("yes")){
                bookingDAO.exportToCSV(getCarString,userString, numOfDays);
                carServices.removeCarFromFile(SPZ);
                System.out.println("Car booked successfully! ✅");
            } else {
                System.out.println("Booking canceled ❌");
            }
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input ❌");
        }

    }

    public void viewUserBookings(){
        // program prints the users, Then u have to select specific user and ull see what he booked.
        Scanner scanner = new Scanner(System.in);
        userServices.viewAllUsers("All");
        System.out.println("---------------------------------");

        System.out.println("Enter userID: ");
        String userInput = scanner.nextLine();
        List<Booking> bookingList =  bookingDAO.getAllBookings();
        for (Booking booking : bookingList) {
            User user = booking.getUser();

            if (user.getUserid().equalsIgnoreCase(userInput)) {
                System.out.println(booking.detailedString());
            }
        }
    }

    public void viewAllBookings() {
        // program prints all bookings

        List<Booking> bookingList = bookingDAO.getAllBookings();
        for (Booking booking : bookingList) {
            System.out.println(booking.detailedString());
        }
    }

    public List<String> isCarBooked(){

        List<String> spzList = new ArrayList<>();
        for (Booking booking : bookingDAO.getAllBookings()) {
            spzList.add(booking.getCar().getRegNum());
        }
        return spzList;
    }



}