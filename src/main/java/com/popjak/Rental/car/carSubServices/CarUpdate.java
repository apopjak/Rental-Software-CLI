package com.popjak.Rental.car.carSubServices;

import com.popjak.Rental.car.*;
import org.springframework.stereotype.*;
import java.util.*;
import static com.popjak.Rental.util.StringIntegerChecker.*;

@Component
public class CarUpdate {

    private final CarDAO carDAO;
    Scanner sc = new Scanner(System.in);
    public CarUpdate(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void carUpdate() {
        /*
        Method flow:
        1. List all cars
        2. Ask user to select ID of the car
        3. Check if ID is not registered already if not
        4. ask all other details
        5. Save the car and remove the old one from the system
         */

        carDAO.listAllCars().forEach(System.out::println);
        System.out.print("\nSelect ID of the car you want to update: ");
        String input = stringIntegerChecker(sc.nextLine());
        if (input == null) return;

        Integer Id = Integer.parseInt(input);

        if (!carDAO.existsById(Id)){
            System.out.println("❌ ID not in DB");
            return;
        }

        Car oldCar = carDAO.getCarById(Id);

        System.out.print("Registration Number: ");
        String regNum = sc.nextLine().toUpperCase().trim();
        if (carDAO.existsByRegNum(regNum) & !oldCar.getRegNum().equalsIgnoreCase(regNum)) {
            System.out.println("❌ Car belongs to other registered car");
            return;
        }

        Car car = CarRegistrationInput.saveCar(regNum);
        if (car == null) return;

        System.out.println(car.registrationString());
        System.out.print("This is the car you are registering\nWould you like to continue? 'yes', 'no': ");

        String confirmation = sc.nextLine();
        if (confirmation.substring(0, 1).equalsIgnoreCase("y")) {
            carDAO.insertIntoDB(car);
            System.out.println("✅ Car updated ");
        } else {
            System.out.println("❌ Cancelled");
        }
        carDAO.removerCarEntity(oldCar);
    }
}
