package com.popjak.booking;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface BookingDAO {

    File accessToFile(String path) throws IOException;
    void exportToCSV(String carSelection, String userSelection,int days);
    List<Booking> getAllBookings();


}
