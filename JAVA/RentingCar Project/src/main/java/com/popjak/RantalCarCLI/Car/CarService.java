package com.popjak.RantalCarCLI.car;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarJPADataAccessService carJPA;

    @Autowired
    public CarService(CarJPADataAccessService carJPA) {
        this.carJPA = carJPA;
    }

    public void showAllPetrolCars() {
        List<Car> cars = carJPA.showAllCars();
        List<Car> petrol = cars.stream().filter(c -> c.getEngine().equals("Petrol")).toList();
        petrol.forEach(System.out::println);
    }

    public void showAllHybridCars() {
        List<Car> cars = carJPA.showAllCars();
        List<Car> petrol = cars.stream().filter(c -> c.getEngine().equals("Hybrid")).toList();
        petrol.forEach(System.out::println);
    }

    public void showAllElectricCars() {
        List<Car> cars = carJPA.showAllCars();
        List<Car> petrol = cars.stream().filter(c -> c.getEngine().equals("Electric")).toList();
        petrol.forEach(System.out::println);
    }

    // INSERT INTO DB
    public void insertToDB(Car car) {
        if (!carJPA.existByRegNum(car.getRegNum())) {
            carJPA.insertToDB(car);
        } else System.out.println("car in DB already");



    }




}
