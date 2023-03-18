package com.popjak.booking;

import com.popjak.DAO;
import com.popjak.car.Car;
import com.popjak.user.User;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BookingDAO implements DAO<Booking> {
    static String PATH = "src/main/resources/bookings.csv";

    public static void exportToCSV(String carSelection, String userSelection,int days){
        // Method helps to newBookingRequest with exporting into booking.csv

        LocalDate local = LocalDate.now().plusDays(days);
        String date = local.getDayOfMonth() + "." + local.getMonthValue() + "." + local.getYear();
        Random random = new Random();
        try (
                FileWriter fileWriter = new FileWriter(PATH);
                PrintWriter writer = new PrintWriter(fileWriter)
        ) {
            System.out.println(carSelection + userSelection);
            writer.print(carSelection  + "," +  userSelection + "," + random.nextInt(10000,999999) + ","
                    + LocalDate.now() + "," + date + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public List<Booking> getList() {
        // Method returns list of cars in availableCars.csv.

        List<Booking> allBookings = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(accessToFile(PATH));
            while (scanner.hasNext()) {
                String a = scanner.nextLine();
                List<String> temporaryList = new ArrayList<>(new ArrayList<>(List.of(a.split(","))));

                // CAR
                Car car = new Car(temporaryList.get(0),temporaryList.get(1),temporaryList.get(2),
                        temporaryList.get(4),temporaryList.get(3),temporaryList.get(5));

                // USER
                User user = new User(temporaryList.get(7),temporaryList.get(6));

                // BOOKING
                Booking booking = new Booking(car,user);
                allBookings.add(booking);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return allBookings;
    }
}
