package com.popjak.RentalCarCLI.car;

import java.util.*;

public interface CarDAO {

    List<Car> showAllCars();

    void insertToDB(Car car);

    boolean existById(Integer Id);

    boolean existByRegNum(String regNum);

    void removeFromDB(Integer Id);


}
