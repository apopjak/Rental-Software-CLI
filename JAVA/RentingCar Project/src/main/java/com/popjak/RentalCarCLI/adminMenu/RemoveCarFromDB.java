package com.popjak.RentalCarCLI.adminMenu;

import com.popjak.RentalCarCLI.car.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class RemoveCarFromDB {

    private final CarService carService;

    @Autowired
    public RemoveCarFromDB(CarService carService) {
        this.carService = carService;
    }

    public void removeCar() {
        Scanner scanner = new Scanner(System.in);
        carService.showAllCars();
        System.out.print("\nEnter registration number of the car you want to remove:");
        String regNum = scanner.nextLine().toUpperCase();

        if (carService.carRegNumInDB(regNum)) {
            carService.removeCarFromDB(regNum);
            System.out.println("✅ Car has been removed");
        } else {
            System.out.println("❌ Registration number " + regNum + " is not in DB");
        }

    }
}
