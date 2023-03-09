package com.popjak.booking;

import com.popjak.user.UserServices;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingDAO {
    // Method gives access to file
     public static File getAccessToFile() throws IOException {

        File file = new File("src/com/popjak/dataStrorage/booking.csv");
        if (!file.exists()) {
            file.createNewFile();
            return file;
        }
        return file;
    }
    public static void viewUserBookedCars(){
        //  Method asks user what ID you want to check,
        //  and then it prints results how many cars use has booked.

        Scanner scanner = new Scanner(System.in);
        UserServices.viewAllUsers();
        System.out.println("Select userID: \n");
        String uuid = scanner.nextLine().toLowerCase().trim();
        try{
            Scanner reader = new Scanner(BookingDAO.getAccessToFile());
            while (reader.hasNext()) {
                // converting CSV to list and analyzing if car exists in the list.
                List<String> list = new ArrayList<>(List.of(reader.nextLine().split(",")));
                if (list.get(6).equals(uuid)){
                    String detailedView = "User: " + list.get(7) + " userID: " + list.get(6).substring(0,5)
                            + "-****-****-****-************ " + list.get(0) + ", " + list.get(1) + " " + list.get(2) +
                            ", " +list.get(3) + ", " + list.get(4) + ", " + list.get(5) + "€ per day";
                    System.out.println(detailedView);
                }
            }
        } catch (IOException e ){
            System.out.println("error");
        }
    }
    public static List<String> showBookedCars(){
        //Method returns list of booked SPZs

        try {
            Scanner s = new Scanner(BookingDAO.getAccessToFile());
            List<String> bookedSPZ = new ArrayList<>();
            ArrayList<String> a = null;
            while (s.hasNext()) {
                // converting CSV to list and analyzing if car exists in the list.
                a = new ArrayList<>(List.of(s.nextLine().substring(0,7)));
                for (int i = 0; i < a.size(); i++) {
                    bookedSPZ.add(a.get(i));
                }
            }
            return bookedSPZ;
        } catch (IOException e ){
            System.out.println("error");
        }
        return null;
    }
    public static void viewAllBookings() {
        // Method shows current bookings

        System.out.println("The list of current bookings: \n-----------------------\n");
        try{
            Scanner s = new Scanner(BookingDAO.getAccessToFile());
            while (s.hasNext()) {
                // converting CSV to list and analyzing if car exists in the list.
                List<String> list = new ArrayList<>(List.of(s.nextLine().split(",")));
                String detailedView = "User: " + list.get(7) + " userID: " + list.get(6).substring(0,5)
                        + "-****-****-****-************ " + list.get(0) + ", " + list.get(1) + " " + list.get(2) +
                        ", " +list.get(3) + ", " + list.get(4) + ", " + list.get(5) + "€ per day";
                System.out.println(detailedView);
            }
        } catch (IOException e ){
            System.out.println("error");
        }
    }
    static void exportToDatabase(String finalString){
        // Method takes final string and exports it to CSV file.

        if (finalString.contains("not found")) System.out.println("Error, incorrect user or car SPZ");
        try (
                FileWriter fileWriter = new FileWriter(BookingDAO.getAccessToFile(),true);
                PrintWriter writer = new PrintWriter(fileWriter);
        ){
            writer.print(finalString);
        }catch (IOException e ) {
            System.out.println(e.getMessage());
        }
    }
}
