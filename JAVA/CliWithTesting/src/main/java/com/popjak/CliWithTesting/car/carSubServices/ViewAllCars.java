package com.popjak.CliWithTesting.car.carSubServices;

import com.popjak.CliWithTesting.car.*;
import org.springframework.stereotype.*;

@Component
public class ViewAllCars {
    private final CarDAO carDAO;

    public ViewAllCars(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void viewAllCars() {
        carDAO.listAllCars().forEach(System.out::println);
    }
}
