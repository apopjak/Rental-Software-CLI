package com.popjak.car;
import com.popjak.booking.BookingViews;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarServices {


    public static void showAvailableCars(String engineType){
        // Method searching in database for cars based on engine type and returns only cars which are not in bookedCARSDB
        // Method checks if car is not in bookings.csv file. If yes it is not going to be printed.

        // If input = petrol -> it shows diesel and benzin cars
        // If input = electric -> it shows electric cars
        // if input = all -> it shows all cars together


        for (int i = 0; i < CarDAO.getAllCars().size(); i++) {

            List<String> temporaryList = List.of(CarDAO.getAllCars().get(i).split(","));
            if (temporaryList.get(3).equals(engineType) && (!BookingViews.ifCarBooked().contains(temporaryList.get(0)))) {

                // detailed string prints to user.
                String detailedView = temporaryList.get(0) + ", " + temporaryList.get(1) + ", " + temporaryList.get(2) +
                        " " + temporaryList.get(4) +"kw, " + temporaryList.get(3) + ", " + temporaryList.get(5) + " per day";
                System.out.println(detailedView);
            } else if (engineType.equals("ALL") && (!BookingViews.ifCarBooked().contains(temporaryList.get(0)))) {
                String detailedView = temporaryList.get(0) + ", " + temporaryList.get(1) + ", " + temporaryList.get(2) +
                        " " + temporaryList.get(3) +"kw, " + temporaryList.get(4) + ", " + temporaryList.get(5) + " per day";
                System.out.println(detailedView);
            }
        }
    }

    public static String getCarInfo(String regNm){
        // Method looks into CSV file and return the string of the specific car.

        String regNmOutput = "This car not in Database ❌";
        for (int i = 0; i < CarDAO.getAllCars().size(); i++) {
            List<String> temporary = List.of(CarDAO.getAllCars().get(i).split(","));
            if (temporary.get(0).equals(regNm)) {
                regNmOutput = temporary.toString().replace("[","").replace("]","");
            }
        }
        return regNmOutput;
    }

    public static BigDecimal getPrice(String regNm){
        // Method gets a price of specific car based on reg number.

        List<String> list = new ArrayList<>(List.of(getCarInfo(regNm).split(", ")));
        BigDecimal price = new BigDecimal(list.get(5));
        return price;
    }
    public static String getCarStringForCSV(String  carSelection){
        String csvString = "";

        for (int i = 0; i < CarDAO.getAllCars().size(); i++) {

            List<String> temporaryList = List.of(CarDAO.getAllCars().get(i).split(","));
            if (temporaryList.get(0).equals(carSelection)) {
                // detailed string prints to user.
                String detailedView = temporaryList.get(0) + "," + temporaryList.get(1) + "," + temporaryList.get(2) +
                        "," + temporaryList.get(4) +"," + temporaryList.get(3) + "," + temporaryList.get(5) + ",";
                csvString = detailedView;
            }
        }
        return csvString;
    }

}
