package com.popjak.booking;

import com.popjak.car.Car;
import com.popjak.car.CarDAO;
import com.popjak.car.CarService;
import com.popjak.user.User;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingServices {

    public static String getUserStringForDB(User user){
        return user.getUserid() + "," + user.getName();
    }

    public static String getBookingStringForDB(String SPZ){
        String carString;
        try {
            Scanner s = new Scanner(CarDAO.getAccessToFile());
            while (s.hasNext()) {
                // converting CSV to list and analyzing if car exists in the list.
                List<String> list = new ArrayList<>(List.of(s.nextLine().split(",")));
                if (list.get(0).equals(SPZ.toUpperCase())){
                    carString = list.get(0) + "," + list.get(1) + "," + list.get(2)  + "," +
                            list.get(3) + "," + list.get(4) + "," + list.get(5);
                    return carString;
                }
            }

        } catch (IOException e ){
            System.out.println("error");
        }
        return "null";
    }

    public static void newBooking(){
        Scanner s = new Scanner(System.in);
        CarService.showCars("ALL");


        System.out.print("\nEnter SPZ of car u want to book: ");
        String SPZ = s.nextLine().toUpperCase().trim();
        CarService.lookUpCarBySPZ(SPZ);
        if (!CarService.lookUpCarBySPZ(SPZ)) {
            System.out.println("Car not found ❌");
        } else {
            try{
                System.out.print("\nEnter number of days u want to register " + SPZ.toUpperCase() + " for: ");
                BigDecimal numOfDays = new BigDecimal(s.nextLine().trim());
                BigDecimal getCarPrice = CarService.getPrice(SPZ);
                BigDecimal finalPrice = numOfDays.multiply(getCarPrice);
                String selection = """
                        Your selection:
                        ----------------""";
                System.out.println(selection);
                System.out.println(numOfDays + " day(s)\n" + getCarPrice + "€ per day" +
                        "\nTotal bill: " + finalPrice +
                                "€\nConfirm the selection by typing 'yes': ");

                String confirmation = s.nextLine().toUpperCase().trim();
                if (confirmation.charAt(0) == 'Y'){
                    System.out.println("Car booked successfully! ✅");
                    System.out.println(getBookingStringForDB(SPZ));
                } else {
                    System.out.println("Booking canceled ❌");
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid input or car doesn't exist in our database try again. ❌");
            }
        }
    }
}
