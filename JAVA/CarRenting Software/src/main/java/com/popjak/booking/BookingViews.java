package com.popjak.booking;


import com.popjak.user.User;
import com.popjak.user.UserServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BookingViews {
    static BookingDAO bookingDAO = new BookingDAO();

    public static void viewUserBookings(){
        // program prints the users, Then u have to select specific user and ull see what he booked.

        Scanner scanner = new Scanner(System.in);
        UserServices.viewAllUsers();
        System.out.println("---------------------------------");

        System.out.println("Enter userID: ");
        String userInput = scanner.nextLine();
        List<Booking> bookingList = bookingDAO.getList();
        for (Booking booking : bookingList) {
            User user = booking.getUser();

            if (user.getUserid().equalsIgnoreCase(userInput)) {
                System.out.println(booking.detailedString());
            }
        }
    }
    public static void viewAllBookings() {
        // program prints all bookings

        List<Booking> bookingList = bookingDAO.getList();
        for (Booking booking : bookingList) {
            System.out.println(booking.detailedString());
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

}
