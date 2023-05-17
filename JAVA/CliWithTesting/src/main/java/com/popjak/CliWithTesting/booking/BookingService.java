package com.popjak.CliWithTesting.booking;

import jakarta.transaction.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BookingService implements BookingDAO{

    private final BookingRepository bookingJPA;

    public BookingService(BookingRepository bookingJPA) {
        this.bookingJPA = bookingJPA;
    }


    @Override
    @Transactional
    public void insertIntoDB(Booking booking) {

    }

    @Override
    public List<Booking> listAllBookings() {
        return bookingJPA.findAll();
    }
}
