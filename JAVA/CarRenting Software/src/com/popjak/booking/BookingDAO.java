package com.popjak.booking;

import java.io.File;
import java.io.IOException;

public class BookingDAO {
    // Method gives access to file
    public static File getAccessToFile() throws IOException {

        File file = new File("src/com/popjak/dataStrorage/booking.csv");
        if (!file.exists()) {
            file.createNewFile();
            return file;
        }
        return file;
    }

}
