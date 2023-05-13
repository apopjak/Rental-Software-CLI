package com.popjak.CliWithTesting.car;

import java.util.*;

public interface CarDAO {

    void insertIntoDB(Car car);

    List<Car> listAllCars();

    int removeCarFromDBByID(Integer Id);

    void removerCarEntity(Car car);

    Car findById(Integer Id);

    boolean existsById(Integer Id);

    boolean existsByRegNum(String regNum);

    Car saveCar(String regNum);



}
