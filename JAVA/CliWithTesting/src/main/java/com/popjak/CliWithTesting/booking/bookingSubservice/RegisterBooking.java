package com.popjak.CliWithTesting.booking.bookingSubservice;

import com.popjak.CliWithTesting.booking.*;
import org.springframework.stereotype.*;

@Component
public class RegisterBooking {

    private final BookingDAO bookingDAO;

    public RegisterBooking(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }


    public void saveBooking(Booking booking) {
        bookingDAO.insertIntoDB(booking);
    }
}
