package com.popjak.car;

import java.io.File;
import java.io.IOException;

public class CarDAO {
    public static File getAccessToFile() throws IOException {

        File file = new File("src/com/popjak/car/data.csv");
        if (!file.exists()) {
            file.createNewFile();
            return file;
        }
        return file;
    }
}
