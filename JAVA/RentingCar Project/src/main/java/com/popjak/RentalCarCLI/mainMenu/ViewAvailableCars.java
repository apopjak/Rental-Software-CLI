package com.popjak.RentalCarCLI.mainMenu;

import com.popjak.RentalCarCLI.car.*;
import org.springframework.stereotype.*;

@Component
public class ViewAvailableCars {

    private final CarService carService;

    public ViewAvailableCars(CarService carService) {
        this.carService = carService;
    }

    public void showCarBasedOnEngine(String engine) {
        carService.showAllCarsByEngine(engine);
    }

    public void showAllCars() {
        carService.showAllCars();
    }

}
