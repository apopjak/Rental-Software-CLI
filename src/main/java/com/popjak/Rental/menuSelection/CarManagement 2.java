package com.popjak.Rental.menuSelection;

import com.popjak.Rental.bookedCars.bookedCarSubServices.*;
import com.popjak.Rental.car.carSubServices.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class CarManagement {
    private static final Scanner scanner = new Scanner(System.in);

    private final CarRegistration carRegistration;
    private final CarView carView;
    private final CarUpdate carUpdate;
    private final CarRemove carRemove;
    private final BookedCarView bookedCarView;

    public CarManagement(CarRegistration carRegistration, CarView carView, CarUpdate carUpdate, CarRemove carRemove, BookedCarView bookedCarView) {
        this.carRegistration = carRegistration;
        this.carView = carView;
        this.carUpdate = carUpdate;
        this.carRemove = carRemove;
        this.bookedCarView = bookedCarView;
    }


    public void carManagementMenu() {


        boolean program = true;
        while (program) {

            String message = """
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                    >>>>>> 🔸 CAR MANAGEMENT CONSOLE 🔸<<<<<< |
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                    ☉ 1 —>  Show all available cars           |
                    ☉ 2 —>  Show all rented cars              |
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                    ☉ 3 —>  Car registration to system        |
                    ☉ 4 —>  Car update                        |
                    ☉ 5 —>  Car remove                        |
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                    ☉ 0 —>  Back to Admin Menu                |
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                    """;

            System.out.println(message);
            String input = scanner.nextLine();

            switch (input) {
                default -> System.out.println("Wrong Input try again ❌");
                case "0" ->{
                    program = false;
                }
                case "1" ->{
                    System.out.println("================= Show All Available Cars =================");
                    carView.viewAllCars();
                }
                case "2" ->{
                    System.out.println("================= Show All Rented Cars =================");
                    bookedCarView.viewAllBookedCars();
                }
                case "3" ->{
                    System.out.println("================= Car Registration =================");
                    carRegistration.carRegistration();
                }
                case "4" ->{
                    System.out.println("================= Car Update =================");
                    carUpdate.carUpdate();
                }
                case "5" -> {
                    System.out.println("================= Car Remove =================");
                    carRemove.carDelete();
                }
            }
        }
    }
}
