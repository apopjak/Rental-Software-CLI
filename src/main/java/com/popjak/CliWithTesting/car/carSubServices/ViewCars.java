package com.popjak.CliWithTesting.car.carSubServices;

import com.popjak.CliWithTesting.car.*;
import org.springframework.stereotype.*;

@Component
public class ViewCars {
    private final CarDAO carDAO;

    public ViewCars(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void viewAllCars() {
        carDAO.listAllCars().forEach(System.out::println);
    }

    public Car selectCarById(Integer Id) {
        return carDAO.findCarById(Id);
    }
}
