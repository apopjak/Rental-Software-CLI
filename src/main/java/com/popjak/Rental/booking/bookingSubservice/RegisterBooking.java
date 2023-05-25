package com.popjak.Rental.booking.bookingSubservice;

import com.popjak.Rental.booking.*;
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
