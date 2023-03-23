package com.popjak.car;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface CarDAO {

    File accessToFile() throws IOException;
    List<Car> getAllCars();
}


