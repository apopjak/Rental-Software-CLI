package com.popjak.RentalCarCLI.adminMenu;

import com.popjak.RentalCarCLI.car.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

import static com.popjak.RentalCarCLI.utils.ToTitleCaseString.*;


@Component
public class RegisterCar {

    private final CarService carService;

    @Autowired
    public RegisterCar(CarService carService) {
        this.carService = carService;
    }

    public void registerNewCarIntoDB() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter all necessary details");

        // reg num
        System.out.print("Registration number: ");
        String regNUm = scanner.nextLine().toUpperCase();

        // make
        System.out.print("Make of the car: ");
        String make = titleCase(scanner.nextLine());

        // model
        System.out.print("Model of the car: ");
        String model = titleCase(scanner.nextLine());

        // engine
        System.out.print("Engine type 'Electric', 'Hybrid', 'Petrol': ");
        String engine = titleCase(scanner.nextLine());
        if (!engine.equals("Electric") && !engine.equals("Hybrid") && !engine.equals("Petrol")) {
            System.out.println("❌ You did not enter valid engine type. Try again ");
            return;
        }

        // year, kw, price
        Object year = null;
        Object kw = null;
        Object price = null;
        try {
            System.out.print("Manufacture year: ");
            year = scanner.nextInt();

            System.out.print("kw (power): ");
            kw = scanner.nextInt();

            System.out.print("Rent price per day: ");
            price = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("❌ You have to enter valid number format!");
        }
        if (carService.carRegNumInDB(regNUm)) {
            System.out.println("❌ This " + regNUm + " is already registered.");
            return;
        }

        Car car = new Car(regNUm,make,model, String.valueOf(year), String.valueOf(kw),engine, String.valueOf(price));
        carService.insertToDB(car);

        System.out.println("✅ Car Registered.");
    }
}
