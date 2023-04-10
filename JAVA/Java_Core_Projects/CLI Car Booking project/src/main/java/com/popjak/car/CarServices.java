package com.popjak.car;


import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class CarServices {

    private final CarDAO carDAO;

    public CarServices(CarDAO carDAO) {
        this.carDAO = carDAO;
    }


    public void showAvailableCars(String petrol,String electric,String hybrid){
        /* Method shows car based on entered STRING argument
          IN THIS ORDER: PETROL , ELECTRIC , HYBRID
          If u don't want to show for example electric, enter NONE instead of electric.**/

        List<Car> carList = carDAO.getAllCars()
                .stream()
                .filter(car -> car.getEngineType().equals(petrol)
                            || car.getEngineType().equals(electric)
                            || car.getEngineType().equals(hybrid))
                .toList();

        for (Car car : carList) {
            System.out.println(car.toDetailedString());
        }

    }
    public String getCarInfo(String regNm){
        // Method looks into CSV file and return the string of the specific car.

        List<Car> regNmOutput  = carDAO.getAllCars()
                .stream()
                .filter(car -> car.getRegNum().equalsIgnoreCase(regNm))
                .toList();

        return regNmOutput.toString().substring(1,regNmOutput.toString().length() - 1);
    }

    public void removeCarFromFile(String regNum) {
        //Remove specific car by regNum,

        // Temporary list where all cars are saved
        List <String> temporaryList = new ArrayList<>();
        try (
                FileWriter fileWriter = new FileWriter(carDAO.accessToFile(), true);
                PrintWriter writer = new PrintWriter(fileWriter)
                ){
            Scanner scanner = new Scanner(carDAO.accessToFile());
            
            // adds values to temporaryList
            while (scanner.hasNext()) {
                String item = scanner.nextLine();
                if (!item.substring(0,7).equalsIgnoreCase(regNum)) {
                    temporaryList.add(item);
                }
            }
//          second FileWriter APPEND FALSE remove all the content and then new adjusted content is added
            FileWriter contentRemoval = new FileWriter(carDAO.accessToFile());
            for (String s : temporaryList) {
                writer.println(s);
            }
            contentRemoval.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
