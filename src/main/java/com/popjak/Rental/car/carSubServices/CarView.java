package com.popjak.Rental.car.carSubServices;

import com.popjak.Rental.car.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class CarView {
    private final CarDAO carDAO;

    public CarView(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void viewAllCars() {
        carDAO.listAllCars().forEach(System.out::println);
    }

    public Car selectCarById(Integer Id) {
        return carDAO.getCarById(Id);
    }

    public void viewAllCarsBasedOnEngineType() {
        Scanner scanner = new Scanner(System.in);
        String message = """
                Car Engine Selection
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                ☉ 1 —>  Electric Cars                     |
                ☉ 2 —>  Petrol Cars                       |
                ☉ 3 —>  Hybrid Cars                       |
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                ☉ 0 —>  Cance;                            |
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                """;

        System.out.println(message);

        String engineTypeInput = scanner.nextLine().toUpperCase().trim();
        List<Car> listOfCars = carDAO.listAllCars();

        switch (engineTypeInput) {
            default -> System.out.println("❌ Incorrect engine type");
            case "2" -> listOfCars.stream().filter(c->c.getEngine().equals("PETROL")).toList().forEach(System.out::println);
            case "1" -> listOfCars.stream().filter(c->c.getEngine().equals("ELECTRIC")).toList().forEach(System.out::println);
            case "3" -> listOfCars.stream().filter(c->c.getEngine().equals("HYBRID")).toList().forEach(System.out::println);
            case "0" -> {
                return;
            }
        }

    }

}
