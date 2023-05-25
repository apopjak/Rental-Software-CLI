package com.popjak.Rental.booking;

import java.util.*;

public interface BookingDAO {

    void insertIntoDB(Booking booking);

    List<Booking> listAllBookings();

}
