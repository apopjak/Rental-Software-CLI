package com.popjak.Rental.car;

import jakarta.transaction.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class CarService implements CarDAO{
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    @Transactional
    public void insertIntoDB(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> listAllCars() {
        return carRepository.findAll();
    }

    @Override
    @Transactional
    public int removeCarFromDBByID(Integer Id) {
        if (!carRepository.existsCarById(Id)) {
            System.out.println("❌ This ID not in DB");
            return 0;
        }
        Car car = carRepository.findCarById(Id);
        carRepository.delete(car);
        return 1;
    }

    @Override
    @Transactional
    public void removerCarEntity(Car car) {
        carRepository.delete(car);
    }

    @Override
    public Car getCarById(Integer Id) {
        if (!carRepository.existsCarById(Id)) {
            System.out.println("❌ This ID not in DB");
            return null;
        }
        return carRepository.findCarById(Id);
    }

    @Override
    public boolean existsById(Integer Id) {
        return carRepository.existsCarById(Id);
    }

    @Override
    public boolean existsByRegNum(String regNum) {
        if (!regNum.isEmpty()) {
            return carRepository.existsCarByRegNum(regNum);
        }
        return false;
    }
}
