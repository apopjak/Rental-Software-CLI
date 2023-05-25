package com.popjak.Rental.booking;

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
        bookingJPA.save(booking);
    }

    @Override
    public List<Booking> listAllBookings() {
        return bookingJPA.findAll();
    }
}
