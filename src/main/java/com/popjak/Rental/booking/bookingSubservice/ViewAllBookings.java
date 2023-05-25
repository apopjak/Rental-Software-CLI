package com.popjak.Rental.booking.bookingSubservice;

import com.popjak.Rental.booking.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class ViewAllBookings {

    private final BookingDAO bookingDAO;

    public ViewAllBookings(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    public void showAllBookings() {
        List<Booking> allBookings = bookingDAO.listAllBookings();
        allBookings.forEach(System.out::println);
    }
}
