package com.popjak.RantalCarCLI.car;

import java.util.List;

public interface CarDAO {

    List<Car> showAllCars();

    void insertToDB(Car car);

    boolean existByRegNum(String regNum);
}
