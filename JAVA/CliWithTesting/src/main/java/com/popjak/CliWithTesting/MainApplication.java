package com.popjak.CliWithTesting;


import com.popjak.CliWithTesting.car.*;
import com.popjak.CliWithTesting.car.carSubServices.*;
import com.popjak.CliWithTesting.user.*;
import com.popjak.CliWithTesting.user.userSubServices.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

import java.util.*;

import static com.popjak.CliWithTesting.util.ScreenCleaner.*;
import static com.popjak.CliWithTesting.util.StringIntegerChecker.*;

@SpringBootApplication
public class MainApplication {

	// User dependencies
	private final ViewUsers viewUsers;
	private final UserRegistration userRegistration;
	private final UserUpdate userUpdate;
	private final UserDelete userDelete;


	// Car dependencies

	private final CarDelete carDelete;
	private final CarRegistration carRegistration;
	private final CarUpdate carUpdate;
	private final ViewCars viewCars;

	public MainApplication(ViewUsers viewUsers, UserRegistration userRegistration, UserUpdate userUpdate,
						   UserDelete userDelete, CarDelete carDelete, CarRegistration carRegistration,
						   CarUpdate carUpdate, ViewCars viewCars) {
		this.viewUsers = viewUsers;
		this.userRegistration = userRegistration;
		this.userUpdate = userUpdate;
		this.userDelete = userDelete;
		this.carDelete = carDelete;
		this.carRegistration = carRegistration;
		this.carUpdate = carUpdate;
		this.viewCars = viewCars;
	}


	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> {

			newBooking();


		};
	}

	private void mainProgram() {

		Scanner scanner = new Scanner(System.in);
		boolean program = true;
		while (program) {

			String message = """

				-------------------------------------
				1 --> Car Registration
				2 --> View All cars
				3 --> Car update
				4 --> Car remove

				0 --> Exit                         
				------------------------------------					
					""";

			System.out.println(message);
			String input = scanner.nextLine();

			switch (input) {
				default -> System.out.println("Wrong Input try again ❌");
				case "0" -> {
					System.out.println("Thank you for using our service, Have a great day.");
					program = false;
				}
				case "1" -> {
					screenCleaner();
					System.out.println("--------- Car registration -------------------------------------\n");

				}
				case "2" -> {
					screenCleaner();
					System.out.println("--------- View All cars -------------------------------------\n");


				}
				case "3" -> {
					screenCleaner();
					System.out.println("--------- Car update -------------------------------------\n");

				}
				case "4" -> {
					screenCleaner();
					System.out.println("--------- Car delete -------------------------------------\n");

				}
				case "5" -> {
					System.out.println("--------- View ALL available cars -------------------------------------");

				}
				case "6" -> {
					System.out.println("--------- Register new account -------------------------------------");

				}

				case "9" -> {

				}

			}

		}


	}

	private void newBooking() {
		Scanner scanner = new Scanner(System.in);

		// *** USER SELECTION ***
		viewUsers.viewAllUsers(); // print all users
		System.out.print("select user ID: ");
		String userID = stringIntegerChecker(scanner.nextLine().trim()); // user id input
		if (userID == null) return;
		User user = viewUsers.selectUserById(Integer.parseInt(userID));
		if (user == null) return;


		// *** CAR SELECTION ***
		viewCars.viewAllCars();
		System.out.print("select car ID: ");
		String carID = stringIntegerChecker(scanner.nextLine().trim());
		if (carID == null) return;
		Car car = viewCars.selectCarById(Integer.parseInt(carID));
		if (car == null) return;
		System.out.println(car);


		// *** NUMBER OF DAYS ***
		System.out.print("How many days is car going to be rented for?: ");
		String numberOfDays = stringIntegerChecker(scanner.nextLine());
		if (numberOfDays == null) return;
		int finalPrice = Integer.parseInt(car.getPrice()) * Integer.parseInt(numberOfDays);

		// ** FINAL PRICE CALCULATION
		System.out.println("=================================\nYour selection: \n-------------------------------- ");
		System.out.println("User: " + user.getFirstName() + " " + user.getLastName() + ", email: " + user.getEmail() );
		System.out.println("Car: " + car.getBrand() + " " + car.getModel() + ", " + car.getYear() + ", " + car.getKw() + "kw");
		System.out.println("Final price for " + numberOfDays + " day(s) = " + finalPrice + " €");

		





	}

}
