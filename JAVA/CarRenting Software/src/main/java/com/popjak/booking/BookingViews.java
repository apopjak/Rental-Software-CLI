package com.popjak.booking;


import com.popjak.car.Car;
import com.popjak.user.User;
import com.popjak.user.UserServices;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BookingViews {

    public static void viewUserBookings(){
        Scanner scanner = new Scanner(System.in);
        UserServices.viewAllUsers();
        System.out.println("---------------------------------");

        System.out.println("Enter userID: ");
        String userInput = scanner.nextLine();
        List<Booking> bookingList = BookingDAO.getAllBookings();
        for (Booking booking : bookingList) {
            Car car = booking.getCar();
            User user = booking.getUser();

            if (user.getUserid().equalsIgnoreCase(userInput)) {
                String detailedView = "BookingID: " + booking.getBookingId() + ", " + user.getUserid().substring(0, 6)
                        + "-******, " + user.getName() + ", Car: " + car.getCarName() + " " + car.getYear() + ", " +
                        car.getPowerInKw() + "kw, " + car.getEngineType() + ",   " + car.getRentPerDay() + " per day. Car booked on: " +
                        booking.getDate();
                System.out.println(detailedView);
            }
        }
    }

    public static void viewAllBookings() {
        List<Booking> bookingList = BookingDAO.getAllBookings();
        for (Booking booking : bookingList) {
            Car car = booking.getCar();
            User user = booking.getUser();
             String detailedView = "BookingID: " + booking.getBookingId() + ", " + user.getUserid().substring(0, 6)
                    + "-******, " + user.getName() + ", Car: " + car.getCarName() + " " + car.getYear() + ", " +
                    car.getPowerInKw() + "kw, " + car.getEngineType() + ",   " + car.getRentPerDay() + " per day. Car booked on: " +
                    booking.getDate();
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
    public static List<String> isCarBooked(){
        List<Booking> bookingList = BookingDAO.getAllBookings();
        List<String> spzList = new ArrayList<>();

        for (int i = 0; i < bookingList.size(); i++) {
            spzList.add(bookingList.get(i).getCar().getRegNum());
        }
        return spzList;
    }
}
