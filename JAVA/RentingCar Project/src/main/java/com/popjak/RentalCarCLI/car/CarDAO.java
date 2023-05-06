package com.popjak.RentalCarCLI.car;

import java.util.*;

public interface CarDAO {

    List<Car> showAllCars();

    void insertToDB(Car car);

    boolean existByRegNum(String regNum);

    void removeFromDB(String regNum);
}
