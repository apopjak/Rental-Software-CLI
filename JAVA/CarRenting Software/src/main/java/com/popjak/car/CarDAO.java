package com.popjak.car;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarDAO {

    static String PATH = "src/main/resources/availableCars.csv";

    static File accessToCSV() throws IOException {
        File file = new File(PATH);
        if (!file.exists()) {
            file.createNewFile();
            return file;
        }
        return file;
    }
    List<Car> getList() {
        List<Car> allCars = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(accessToCSV());
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


