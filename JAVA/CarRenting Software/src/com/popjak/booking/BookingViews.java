package com.popjak.booking;


import com.popjak.user.UserServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BookingViews {

    public static void viewUserBookings() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        UserServices.viewAllUsers();
        System.out.println("---------------------------------");

        System.out.println("Enter userID: ");
        String userInput = scanner.nextLine();

        for (int i = 0; i < BookingDAO.getAllBookings().size(); i++) {
            List<String> temporaryList = List.of(BookingDAO.getAllBookings().get(i).split(","));
            String oldTime = temporaryList.get(9), newTime = temporaryList.get(10);
            long remainingDays = remainingDays(oldTime,newTime);
            if(userInput.equalsIgnoreCase(temporaryList.get(7))) {
                String detailedView = temporaryList.get(7).substring(0,6) + "-******, " + temporaryList.get(6) + ", "
                        + temporaryList.get(0) + ", " + temporaryList.get(1) + ", " + temporaryList.get(2) +
                        " " + temporaryList.get(3) +"kw, " + temporaryList.get(4) + ", " + temporaryList.get(5) +
                        " per day, booking date: " + temporaryList.get(9) + ", remaining days: " + remainingDays;
                System.out.println(detailedView);
            }
        }
    }

    public static void viewAllBookings() throws ParseException {

        for (int i = 0; i < BookingDAO.getAllBookings().size(); i++) {

            List<String> temporaryList = List.of(BookingDAO.getAllBookings().get(i).split(","));
            String oldTime = temporaryList.get(9), newTime = temporaryList.get(10);
            long remainingDays = remainingDays(oldTime,newTime);

            // detailed string prints to user.
            String detailedView = temporaryList.get(7).substring(0,6) + "-******, " + temporaryList.get(6) + ", "
                    + temporaryList.get(0) + ", " + temporaryList.get(1) + ", " + temporaryList.get(2) +
                    " " + temporaryList.get(3) +"kw, " + temporaryList.get(4) + ", " + temporaryList.get(5) +
                    " per day, booking date: " + temporaryList.get(9) + ", remaining days: " + remainingDays;
            System.out.println(detailedView);
        }
    }

    private static long remainingDays(String booking, String endDay) throws ParseException {
        // calculates remaining number of days

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(booking);
        Date secondDate = sdf.parse(endDay);
        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());

        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
    public static List<String> ifCarBooked(){
        List<String> bookedSPZ = new ArrayList<>();
        String a = null;
        for (int i = 0; i < BookingDAO.getAllBookings().size(); i++) {
            List<String> temporaryList = List.of(BookingDAO.getAllBookings().get(i).split(","));
            a = temporaryList.get(0);
            bookedSPZ.add(a);
        }
        return bookedSPZ;
    }
}
