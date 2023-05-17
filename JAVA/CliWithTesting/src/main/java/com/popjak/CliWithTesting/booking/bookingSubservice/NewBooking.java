package com.popjak.CliWithTesting.booking.bookingSubservice;

import com.popjak.CliWithTesting.booking.*;
import org.springframework.stereotype.*;

@Component
public class NewBooking {

    private final BookingDAO bookingDAO;

    public NewBooking(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }


    void saveBooking(Booking booking) {
        bookingDAO.insertIntoDB(booking);
    }
}
