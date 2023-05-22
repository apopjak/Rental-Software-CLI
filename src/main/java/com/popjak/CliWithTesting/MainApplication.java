package com.popjak.CliWithTesting;


import com.popjak.CliWithTesting.BookedCars.*;
import com.popjak.CliWithTesting.BookedCars.bookedCarSubServices.*;
import com.popjak.CliWithTesting.booking.*;
import com.popjak.CliWithTesting.booking.bookingSubservice.*;
import com.popjak.CliWithTesting.car.*;
import com.popjak.CliWithTesting.car.carSubServices.*;
import com.popjak.CliWithTesting.user.*;
import com.popjak.CliWithTesting.user.userSubServices.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

import java.time.*;
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

	// Booking dependencies
	private final RegisterBooking registerBooking;
	private final ViewAllBookings viewAllBookings;

	// Booked cars dependenices
	private final BookedCarDBInsert bookedCarDBInsert;

	public MainApplication(ViewUsers viewUsers, UserRegistration userRegistration, UserUpdate userUpdate,
						   UserDelete userDelete, CarDelete carDelete, CarRegistration carRegistration,
						   CarUpdate carUpdate, ViewCars viewCars, RegisterBooking registerBooking,
						   ViewAllBookings viewAllBookings, BookedCarDBInsert bookedCarDBInsert) {
		this.viewUsers = viewUsers;
		this.userRegistration = userRegistration;
		this.userUpdate = userUpdate;
		this.userDelete = userDelete;
		this.carDelete = carDelete;
		this.carRegistration = carRegistration;
		this.carUpdate = carUpdate;
		this.viewCars = viewCars;
		this.registerBooking = registerBooking;
		this.viewAllBookings = viewAllBookings;
		this.bookedCarDBInsert = bookedCarDBInsert;
	}


	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> {

			mainProgram();


		};
	}

	private void mainProgram() {

		Scanner scanner = new Scanner(System.in);
		boolean program = true;
		while (program) {

			String message = """
					1 —>  Rent a car
					2 —>  View available cars
					3 —>  Register new user account
					4 —>  ADMIN MENU
					0 —>  Exit
					""";

			System.out.println(message);
			String input = scanner.nextLine();

			switch (input) {
				default -> System.out.println("Wrong Input try again ❌");
				case "0" ->{
					System.out.println("Thank you for using our service, Have a great day.");
					program = false;
				}
				case "1" ->{
					screenCleaner();
					System.out.println("================= Rent a car =================");
					newBooking();
				}
				case "2" ->{
					screenCleaner();
					System.out.println("--------- View available cars -------------------------------------\n");
					viewCars.viewAllCars();
					// TODO: create extramenu for this input

				}
				case "3" ->{
					screenCleaner();
					System.out.println("--------- Register new user account -------------------------------------\n");
					userRegistration.userRegistration();
				}
				case "4" ->{
					screenCleaner();
					System.out.println("--------- ADMIN MENU -------------------------------------\n");
					carRegistration.carRegistration();
					//TODO: create extramenu for this input
				}
			}

		}


	}

	private void newBooking() {
		Scanner scanner = new Scanner(System.in);

		// *** USER SELECTION ***
		System.out.print("Enter your email address: ");
		String userEmail = scanner.nextLine().trim().toLowerCase(); // user id input
		if (!viewUsers.userExists(userEmail)) {
			System.out.println("❌ This user is not registered");
			return;
		}
		User user = viewUsers.selectUserById(userEmail);


		// *** CAR SELECTION ***
		System.out.println("=====================================================================");
		viewCars.viewAllCars();
		System.out.println("=====================================================================\n");

		System.out.print("Enter ID of the car you want to rent: ");
		String carID = stringIntegerChecker(scanner.nextLine().trim());
		if (carID == null) return;
		Car car = viewCars.selectCarById(Integer.parseInt(carID));
		if (car == null) return;
		System.out.println("✅\n=====================================================================\n");


		// *** NUMBER OF DAYS ***
		System.out.print("How many days you want to use " + car.getBrand() + " " + car.getModel() + " for? : ");
		String numberOfDays = stringIntegerChecker(scanner.nextLine());
		if (numberOfDays == null) return;
		int finalPrice = Integer.parseInt(car.getPrice()) * Integer.parseInt(numberOfDays);

		// ** FINAL PRICE CALCULATION
		System.out.println("=====================================================================\nYOUR SELECTION \n=====================================================================\n ");
		System.out.println("User: " + user.getFirstName() + " " + user.getLastName() + ", email: " + user.getEmail() );
		System.out.println("Car: " + car.getBrand() + " " + car.getModel() + ", " + car.getYear() + ", " + car.getKw() + "kw");
		System.out.println("Final price for " + numberOfDays + " day(s) = " + finalPrice + " €");

		System.out.println("\n======================\nDo you wish to continue? 'yes' or 'no' : ");
		String conf = scanner.nextLine().toLowerCase().trim();

		if (conf.charAt(0) != 'y') {
			System.out.println("❌ Car rental procedure cancelled ");
			return;
		}

		/*
		1. Create booking object
		2. Add selected car into BookedCar DB
		3. Remove Car from carBD, so it is not showing as a available car
		4. give confirmation if conditions above are met.
		 */

		// 1. Create booking object
		Booking booking = new Booking(Integer.parseInt(numberOfDays),
									car.getRegNum(),
									user.getEmail(),
									finalPrice);

		// 2. car added to Booked car DB and booking save indo DB bookin_data
		BookedCar bookedCar = new BookedCar(car.getRegNum(),
											car.getBrand(),
											car.getModel(),
											car.getYear(),
											car.getKw(),
											car.getEngine(),
											car.getPrice());

		bookedCarDBInsert.bookedCarDBInsert(bookedCar);
		registerBooking.saveBooking(booking);

		// 3. Car entity deleted
		carDelete.carDeleteEntity(car);

		System.out.println("✅ Registration successful");





	}

	private static String endDateCalc(int days) {
		LocalDate endDate = LocalDate.now().plusDays(days);
		return endDate.getDayOfMonth() + "." + endDate.getMonth() + "." + endDate.getYear();
	}

}
