package com.popjak.CliWithTesting.BookedCars;


import jakarta.transaction.*;
import org.springframework.stereotype.*;


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
}
