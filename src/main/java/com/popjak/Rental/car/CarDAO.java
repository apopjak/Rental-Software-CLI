package com.popjak.Rental.car;

import java.util.*;

public interface CarDAO {

    void insertIntoDB(Car car);

    List<Car> listAllCars();

    int removeCarFromDBByID(Integer Id);

    void removerCarEntity(Car car);

    Car getCarById(Integer Id);

    boolean existsById(Integer Id);

    boolean existsByRegNum(String regNum);




}
