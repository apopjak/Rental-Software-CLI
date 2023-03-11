package com.popjak.car;


import com.popjak.booking.BookingViews;

import java.math.BigDecimal;
import java.util.List;

public class CarServices {

    public static void showAvailableCars(String engineType){
//         Method searching in database for cars based on engine type and returns only cars which are not in bookedCARSDB
//         Method checks if car is not in bookings.csv file. If yes it is not going to be printed.
//         If input = petrol -> it shows diesel and benzin cars
//         If input = electric -> it shows electric cars
        //         if input = all -> it shows all cars together

        List<Car> carList = CarDAO.getAllCars();
        for (Car car : carList) {

            if (car.getEngineType().equals(engineType) && (!BookingViews.ifCarBooked().contains(car.getRegNum()))) {
                // detailed string prints to user.
                String detailedView = car.getRegNum() + ", " + car.getCarName() + ", " + car.getYear() +
                        " " + car.getPowerInKw() + "kw, " + car.getEngineType() + ", " + car.getRentPerDay() + " per day";
                System.out.println(detailedView);

            } else if (engineType.equals("ALL") && (!BookingViews.ifCarBooked().contains(car.getRegNum()))) {
                String detailedView = car.getRegNum() + ", " + car.getCarName() + ", " + car.getYear() +
                        " " + car.getPowerInKw() + "kw, " + car.getEngineType() + ", " + car.getRentPerDay() + " per day";

                System.out.println(detailedView);
            }
        }
    }
    public static String getCarInfo(String regNm){
        // Method looks into CSV file and return the string of the specific car.
        List<Car> carList = CarDAO.getAllCars();
        String regNmOutput = "This car not in Database ❌";

        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getRegNum().equalsIgnoreCase(regNm)) {
                regNmOutput = carList.get(i).toString();
            }
        }
        return regNmOutput;
    }

    public static int getPrice(String regNm){
        // Method gets a price of specific car based on reg number.

        List<Car> carList = CarDAO.getAllCars();
        int price = 0;
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getRegNum().equalsIgnoreCase(regNm))
                price = carList.get(i).getRentPerDay();
        }
        System.out.println(price);
        return price;
    }
}
