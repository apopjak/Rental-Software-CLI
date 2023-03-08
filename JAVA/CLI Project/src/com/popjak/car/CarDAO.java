package com.popjak.car;

import java.io.File;
import java.io.IOException;

public class CarDAO {
    public static File getAccessToFile() throws IOException {
        // Method gives access to file.

        File file = new File("src/com/popjak/dataStrorage/availableCarsDB.csv");
        if (!file.exists()) {
            file.createNewFile();
            return file;
        }
        return file;
    }
}
