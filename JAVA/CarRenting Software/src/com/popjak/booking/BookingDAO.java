package com.popjak.booking;

import com.popjak.car.CarServices;
import com.popjak.user.UserServices;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingDAO {
    public static File accessToFile() throws IOException {
        File file = new File("src/com/popjak/data/bookings.csv");
        if (!file.exists()) {
            file.createNewFile();
            return file;
        }
        return file;
    }
    public static void exportToCSV(String carSelection, String userSelection, int days){
        Booking booking = new Booking();
        LocalDate local = LocalDate.now().plusDays(days);
        String date = local.getDayOfMonth() + "." + local.getMonthValue() + "." + local.getYear();

        try (
                FileWriter fileWriter = new FileWriter(BookingDAO.accessToFile(), true);
                PrintWriter writer = new PrintWriter(fileWriter);
        ) {
            writer.print(CarServices.getCarStringForCSV(carSelection) + UserServices.getUserStringForDB(userSelection)
                    + booking + "," + date + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static List<String> getAllBookings(){
        // Method returns list of cars in availableCars.csv.

        List<String> allBookings = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(accessToFile());
            while (scanner.hasNext()) {
                String a = scanner.nextLine();
                allBookings.add(a);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return allBookings;
    }
}
