package com.popjak.CliWithTesting.car.carSubServices;

import com.popjak.CliWithTesting.car.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class CarRegistration {

    private final CarDAO carDAO;

    public CarRegistration(CarDAO carDAO) {
        this.carDAO = carDAO;
    }


    public void carRegistration() {
        // Car registration. Method has inputs and conditions for inputs to be correct
        Scanner sc = new Scanner(System.in);
        System.out.print("Registration number: ");
        String regNum = sc.nextLine().toUpperCase();

        if (carDAO.existsByRegNum(regNum)) {
            System.out.println("❌ Car already registered");
            return;
        }

        Car car = carDAO.saveCar(regNum);
        if (car == null) return;

        System.out.println(car.registrationString());
        System.out.print("This is the car you are registering\nWould you like to continue? 'yes', 'no': ");

        String confirmation = sc.nextLine();
        if (confirmation.substring(0, 1).equalsIgnoreCase("y")) {
            carDAO.insertIntoDB(car);
            System.out.println("✅ Success ");
        } else {
            System.out.println("❌ Cancelled");
        }
    }
}
