package com.popjak.CliWithTesting.car;

import jakarta.transaction.*;
import org.springframework.stereotype.*;

import java.util.*;

import static com.popjak.CliWithTesting.util.StringIntegerChecker.stringIntegerChecker;

@Service
public class CarService implements CarDAO{
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    @Transactional
    public void insertIntoDB(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> listAllCars() {
        return carRepository.findAll();
    }

    @Override
    public int removeCarFromDBByID(Integer Id) {
        if (!carRepository.existsCarById(Id)) {
            System.out.println("❌ This ID not in DB");
            return 0;
        }
        Car car = carRepository.findCarById(Id);
        carRepository.delete(car);
        return 1;
    }

    @Override
    public void removerCarEntity(Car car) {
        carRepository.delete(car);
    }

    @Override
    public Car findById(Integer Id) {
        if (!carRepository.existsCarById(Id)) {
            System.out.println("❌ This ID not in DB");
            return null;
        }
        return carRepository.findCarById(Id);
    }

    @Override
    public boolean existsById(Integer Id) {
        return carRepository.existsCarById(Id);
    }

    @Override
    public boolean existsByRegNum(String regNum) {
        if (!regNum.isEmpty()) {
            return carRepository.existsCarByRegNum(regNum);
        }
        return false;
    }

    @Override
    public Car saveCar(String regNum) {
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

    String engineTypeChecker(String engine) {

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
