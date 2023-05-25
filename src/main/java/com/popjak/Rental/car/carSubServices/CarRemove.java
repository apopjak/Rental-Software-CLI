package com.popjak.Rental.car.carSubServices;

import com.popjak.Rental.car.*;
import org.springframework.stereotype.*;

import java.util.*;

import static com.popjak.Rental.util.StringIntegerChecker.*;

@Component
public class CarRemove {

    private final CarDAO carDAO;

    public CarRemove(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void carDelete() {
        Scanner scanner = new Scanner(System.in);
        carDAO.listAllCars().forEach(System.out::println);

        System.out.print("\nSelect ID of the car you want to remove: ");
        String input = stringIntegerChecker(scanner.nextLine());
        if (input == null) return;
        Integer Id = Integer.parseInt(input);

        if (carDAO.removeCarFromDBByID(Id) == 1) {
            System.out.println("✅ Car removed from DB");
        }
    }

    public void carDeleteEntity(Car car) {
        carDAO.removerCarEntity(car);
    }
}
