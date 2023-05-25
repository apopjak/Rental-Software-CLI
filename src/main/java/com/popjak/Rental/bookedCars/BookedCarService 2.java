package com.popjak.Rental.bookedCars;


import jakarta.transaction.*;
import org.springframework.stereotype.*;

import java.util.*;


@Service
public class BookedCarService implements BookedCarDAO {
    private final BookedCarRepository bookedCarRepository;

    public BookedCarService(BookedCarRepository bookedCarRepository) {
        this.bookedCarRepository = bookedCarRepository;
    }


    @Override
    @Transactional
    public void insertIntoDB(BookedCar bookedCar) {
        bookedCarRepository.save(bookedCar);
    }

    @Override
    @Transactional
    public void removeFromDB(BookedCar bookedCar) {
        bookedCarRepository.delete(bookedCar);
    }

    @Override
    public List<BookedCar> listOfBookedCars() {
        return bookedCarRepository.findAll();
    }
}
