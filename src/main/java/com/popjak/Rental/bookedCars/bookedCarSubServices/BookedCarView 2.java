package com.popjak.Rental.bookedCars.bookedCarSubServices;

import com.popjak.Rental.bookedCars.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class BookedCarView {

    private final BookedCarDAO bookedCarDAO;

    public BookedCarView(BookedCarDAO bookedCarDAO) {
        this.bookedCarDAO = bookedCarDAO;
    }

    public void viewAllBookedCars() {
        List<BookedCar> listOfAllBookedCars = bookedCarDAO.listOfBookedCars();
        if (listOfAllBookedCars.size() < 1) {
            System.out.println("❌ All cars are available. Not even one car booked");
            return;
        }
        listOfAllBookedCars.forEach(System.out::println);
    }
}
