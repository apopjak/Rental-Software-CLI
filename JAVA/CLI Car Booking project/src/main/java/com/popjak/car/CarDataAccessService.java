package com.popjak.car;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class CarDataAccessService implements CarDAO{
    static String PATH = "src/main/resources/availableCars.csv";

    @Override
    public File accessToFile() throws IOException {
        // access to file .CSV

        File file = new File(PATH);
        if (!file.exists()) {
            file.createNewFile();
            return file;
        }
        return file;
    }

    @Override
    public List<Car> getAllCars() {
        //Returns list of all cars

        List<Car> allCars = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(accessToFile());
            while (scanner.hasNext()) {
                String a = scanner.nextLine();
                List<String> temporaryList = new ArrayList<>(new ArrayList<>(List.of(a.split(","))));

                Car car = new Car(temporaryList.get(0),temporaryList.get(1),temporaryList.get(2),
                        temporaryList.get(3),temporaryList.get(4),temporaryList.get(5));
                allCars.add(car);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return allCars;
    }

}

