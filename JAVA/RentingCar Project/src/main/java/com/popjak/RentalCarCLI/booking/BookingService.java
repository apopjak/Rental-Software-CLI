package com.popjak.RentalCarCLI.booking;

import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingJPADataServiceAccess bookingJPA;

    public BookingService(BookingJPADataServiceAccess bookingJPA) {
        this.bookingJPA = bookingJPA;
    }

    void insertBookingIntoDB(Booking booking) {
        bookingJPA.insertBookingToDB(booking);
    }
}
