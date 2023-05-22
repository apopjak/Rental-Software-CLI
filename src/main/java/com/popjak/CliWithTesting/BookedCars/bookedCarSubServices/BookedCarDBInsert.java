package com.popjak.CliWithTesting.BookedCars.bookedCarSubServices;

import com.popjak.CliWithTesting.BookedCars.*;
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
