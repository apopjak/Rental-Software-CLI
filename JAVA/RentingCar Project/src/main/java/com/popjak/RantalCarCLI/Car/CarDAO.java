package com.popjak.RantalCarCLI.Car;

import java.util.List;

public interface CarDAO {

    List<Car> showAllCars();

    void insertToDB(Car car);

    boolean existByRegNum(String regNum);
}
