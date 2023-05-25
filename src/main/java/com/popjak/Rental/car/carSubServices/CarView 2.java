package com.popjak.Rental.car.carSubServices;

import com.popjak.Rental.car.*;
import org.springframework.stereotype.*;

@Component
public class CarView {
    private final CarDAO carDAO;

    public CarView(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void viewAllCars() {
        if (carDAO.listAllCars().size() < 1) {
            System.out.println("❌ No available cars at the moment");
        }
        carDAO.listAllCars().forEach(System.out::println);
    }

    public Car selectCarById(Integer Id) {
        return carDAO.getCarById(Id);
    }
}
