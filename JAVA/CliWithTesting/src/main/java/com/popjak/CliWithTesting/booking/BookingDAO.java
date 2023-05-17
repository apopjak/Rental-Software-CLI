package com.popjak.CliWithTesting.booking;

import java.util.*;

public interface BookingDAO {

    void insertIntoDB(Booking booking);

    List<Booking> listAllBookings();
}
