package com.popjak.user;

import java.io.File;
import java.io.IOException;

public class UserDAO {
    public static File getAccessToFile() throws IOException {

        File file = new File("src/com/popjak/dataStrorage/userDB.csv");
        if (!file.exists()) {
            file.createNewFile();
            return file;
        }
        return file;
    }
}
