package com.popjak.RentalCarCLI.car;


import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class CarService {

    private final CarJPADataAccessService carJPA;

    @Autowired
    public CarService(CarJPADataAccessService carJPA) {
        this.carJPA = carJPA;
    }

    public void showAllCarsByEngine(String string) {
        List<Car> cars = carJPA.showAllCars();
        List<Car> petrol = cars.stream().filter(c -> c.getEngine().equals(string)).toList();
        petrol.forEach(System.out::println);
    }

    public void showAllCars() {
        List<Car> cars = carJPA.showAllCars();
        cars.forEach(System.out::println);
    }

    // INSERT INTO DB
    public void insertToDB(Car car) {
        if (!carJPA.existByRegNum(car.getRegNum())) {
            carJPA.insertToDB(car);
        } else System.out.println("car in DB already");
    }

    public boolean carRegNumInDB(String reg) {
        return carJPA.existByRegNum(reg);
    }

    public void removeCarFromDB(String regNum) {
        carJPA.removeFromDB(regNum);
    }




}
