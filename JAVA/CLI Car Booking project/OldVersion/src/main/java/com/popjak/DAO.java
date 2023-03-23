package com.popjak;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface DAO<T> {

    default File accessToFile(String PATH) throws IOException {
        File file = new File(PATH);
        if (!file.exists()) {
            file.createNewFile();
            return file;
        }
        return file;
    }
    List<T> getList();



}


