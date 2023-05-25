package com.popjak.Rental.car.carSubServices;

import com.popjak.Rental.car.*;

import java.util.*;

import static com.popjak.Rental.util.StringIntegerChecker.stringIntegerChecker;

 class CarRegistrationInput {

     static Car saveCar(String regNum) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Brand: ");
        String brand = scanner.nextLine().toUpperCase().trim();

        System.out.print("Model: ");
        String model = scanner.nextLine().toUpperCase().trim();

        System.out.print("Year: ");
        String year = stringIntegerChecker(scanner.nextLine());
        if (year == null) return null;

        System.out.print("kilowatts (kw): ");
        String kw = stringIntegerChecker(scanner.nextLine());
        if (kw == null) return null;

        System.out.print("Engine type (petrol, electric, hybrid): ");
        String engine = engineTypeChecker(scanner.nextLine());
        if (engine == null) return null;

        System.out.print("Rent price per day: ");
        String price = stringIntegerChecker(scanner.nextLine());
        if (price == null) return null;

        return new Car(regNum,brand,model,year,kw,engine,price);
    }

    private static String engineTypeChecker(String engine) {

        if (engine.isEmpty()) return null;
        if (engine.substring(0, 3).equalsIgnoreCase("ele")) {
            return "ELECTRIC";
        } else if (engine.substring(0, 3).equalsIgnoreCase("pet")) {
            return "PETROL";
        } else if (engine.substring(0, 3).equalsIgnoreCase("hyb")) {
            return "HYBRID";
        }
        System.out.println("❌ Incorrect Engine Type");
        return null;
    }
}
