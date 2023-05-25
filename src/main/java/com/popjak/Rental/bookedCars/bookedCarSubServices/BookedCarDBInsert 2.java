package com.popjak.Rental.bookedCars.bookedCarSubServices;

import com.popjak.Rental.bookedCars.*;
import org.springframework.stereotype.*;

@Component
public class BookedCarDBInsert {

    private final BookedCarDAO bookedCarDAO;

    public BookedCarDBInsert(BookedCarDAO bookedCarDAO) {
        this.bookedCarDAO = bookedCarDAO;
    }


    public void bookedCarDBInsert(BookedCar bookedCar) {
        bookedCarDAO.insertIntoDB(bookedCar);
    }
}
