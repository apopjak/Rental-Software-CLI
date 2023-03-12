package com.popjak.car;


import com.popjak.booking.BookingViews;

import java.util.List;

public class CarServices {

    public static void showAvailableCars(String engineType){
        // Method shows available cars. Car cannot be in booking.csv

        List<Car> carList = CarDAO.getAllCars()
                .stream()
                .filter(car -> car.getEngineType().equals(engineType) && (!BookingViews.isCarBooked().contains(car.getRegNum())))
                .toList();
        for (Car car : carList) {
            System.out.println(car.toDetailedString());
        }
    }
    public static String getCarInfo(String regNm){
        // Method looks into CSV file and return the string of the specific car.


        List<Car> regNmOutput  = CarDAO.getAllCars()
                .stream()
                .filter(car -> car.getRegNum().equalsIgnoreCase(regNm) && (!BookingViews.isCarBooked().contains(car.getRegNum())))
                .toList();

        return regNmOutput.toString().substring(1,regNmOutput.toString().length() - 1);
    }
}
