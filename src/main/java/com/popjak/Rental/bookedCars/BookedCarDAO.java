package com.popjak.Rental.bookedCars;

import java.util.*;

public interface BookedCarDAO {

    void insertIntoDB(BookedCar bookedCar);

    void removeFromDB(BookedCar bookedCar);

    List<BookedCar> listOfBookedCars();


}
