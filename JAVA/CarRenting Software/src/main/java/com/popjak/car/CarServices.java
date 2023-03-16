package com.popjak.car;


import com.popjak.booking.Booking;
import com.popjak.booking.BookingDAO;

import java.util.ArrayList;
import java.util.List;

public class CarServices {
    private static CarDAO carDAO;

    public CarServices(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void showAvailableCars(String engineType){
        // Method shows available cars. Car cannot be in booking.csv

        List<Car> carList = carDAO.getList()
                .stream()
                .filter(car -> car.getEngineType().equals(engineType) && (!isCarBooked().contains(car.getRegNum())))
                .toList();
        for (Car car : carList) {
            System.out.println(car.toDetailedString());
        }
    }


    public static String getCarInfo(String regNm){
        // Method looks into CSV file and return the string of the specific car.

        List<Car> regNmOutput  = carDAO.getList()
                .stream()
                .filter(car -> car.getRegNum().equalsIgnoreCase(regNm) && (!isCarBooked().contains(car.getRegNum())))
                .toList();

        return regNmOutput.toString().substring(1,regNmOutput.toString().length() - 1);
    }


    private static List<String> isCarBooked(){
        // Boolean to see if car is booked, That pethod helps to Car Service class to show only available cars.
        BookingDAO bookingDAO = new BookingDAO();
        List<Booking> bookingList = bookingDAO.getList();
        List<String> spzList = new ArrayList<>();

        for (int i = 0; i < bookingList.size(); i++) {
            spzList.add(bookingList.get(i).getCar().getRegNum());
        }
        return spzList;
    }
}
