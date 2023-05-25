package com.popjak.Rental;


import com.popjak.Rental.bookedCars.*;
import com.popjak.Rental.bookedCars.bookedCarSubServices.*;
import com.popjak.Rental.booking.*;
import com.popjak.Rental.booking.bookingSubservice.*;
import com.popjak.Rental.car.*;
import com.popjak.Rental.car.carSubServices.*;
import com.popjak.Rental.menuSelection.*;
import com.popjak.Rental.user.*;
import com.popjak.Rental.user.userSubServices.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

import java.util.*;

import static com.popjak.Rental.util.ScreenCleaner.*;
import static com.popjak.Rental.util.StringIntegerChecker.*;


@SpringBootApplication
public class MainApplication {
		public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> {

			mainProgram();

		};
	}

	private final AdminMenu adminMenu;

	// User dependencies


	private final UserView userView;
	private final UserRegistration userRegistration;
	private final UserUpdate userUpdate;

	// Car dependencies4

	private final CarRemove carRemove;
	private final CarRegistration carRegistration;
	private final CarUpdate carUpdate;
	private final CarView carView;

	// Booking dependencies
	private final RegisterBooking registerBooking;
	private final ViewAllBookings viewAllBookings;

	// Booked cars dependenices
	private final BookedCarDBInsert bookedCarDBInsert;

	public MainApplication(AdminMenu adminMenu, UserView userView, UserRegistration userRegistration, UserUpdate userUpdate,
						   CarRemove carRemove, CarRegistration carRegistration,
						   CarUpdate carUpdate, CarView carView, RegisterBooking registerBooking,
						   ViewAllBookings viewAllBookings, BookedCarDBInsert bookedCarDBInsert) {
		this.adminMenu = adminMenu;
		this.userView = userView;
		this.userRegistration = userRegistration;
		this.userUpdate = userUpdate;
		this.carRemove = carRemove;
		this.carRegistration = carRegistration;
		this.carUpdate = carUpdate;
		this.carView = carView;
		this.registerBooking = registerBooking;
		this.viewAllBookings = viewAllBookings;
		this.bookedCarDBInsert = bookedCarDBInsert;
	}




	private void mainProgram() {
		System.out.println(logo());
		Scanner scanner = new Scanner(System.in);
		boolean program = true;
		while (program) {

			String message = """
				=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
						    MAIN MENU             |
				=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				☉ 1 —>  Rent a car                |
				☉ 2 —>  View available cars       |
				☉ 3 —>  Register new user account |
				=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				☉ 4 —>  ADMIN MENU                |
				☉ 0 —>  Exit                      |
				=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
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
					carView.viewAllCars();
					// todo menu electric petrol hybrid

				}
				case "3" ->{
					screenCleaner();
					System.out.println("--------- Register new user account -------------------------------------\n");
					userRegistration.userRegistration();
				}
				case "4" ->{
					adminMenu.adminMenu();
				}
			}
		}
	}

	private void newBooking() {
		Scanner scanner = new Scanner(System.in);

		// *** USER SELECTION ***
		System.out.print("Enter your email address: ");
		String userEmail = scanner.nextLine().trim().toLowerCase(); // user id input
		if (!userView.userExists(userEmail)) {
			System.out.println("❌ This user is not registered");
			return;
		}
		User user = userView.getUserById(userEmail);

		// *** CAR SELECTION ***
		System.out.println("=====================================================================");
		carView.viewAllCars();
		System.out.println("=====================================================================\n");

		System.out.print("Enter ID of the car you want to rent: ");
		String carID = stringIntegerChecker(scanner.nextLine().trim());
		if (carID == null) return;
		Car car = carView.selectCarById(Integer.parseInt(carID));
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
		2. Add a selected car into BookedCar DB
		3. Remove Car from carBD, so it is not showing as a available car
		4. Give confirmation if the conditions above are met.
		 */

		// 1. Create a booking object
		Booking booking = new Booking(Integer.parseInt(numberOfDays),
				car.getRegNum(),
				user.getEmail(),
				finalPrice);

		// 2. car added to Booked car DB and booking saves indo DB booking_data
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
		carRemove.carDeleteEntity(car);
		System.out.println("✅ Registration successful");
	}


	private String logo() {
		String logo = """

				8888888b.                   888             888       .d8888b.                  \s
				888   Y88b                  888             888      d88P  Y88b                 \s
				888    888                  888             888      888    888                 \s
				888   d88P .d88b.  88888b.  888888  8888b.  888      888         8888b.  888d888\s
				8888888P" d8P  Y8b 888 "88b 888        "88b 888      888            "88b 888P"  \s
				888 T88b  88888888 888  888 888    .d888888 888      888    888 .d888888 888    \s
				888  T88b Y8b.     888  888 Y88b.  888  888 888      Y88b  d88P 888  888 888    \s
				888   T88b "Y8888  888  888  "Y888 "Y888888 888       "Y8888P"  "Y888888 888    \s
				                                                                                \s
				                                                                                \s
				                                                                                \s
				""";
		return logo;
	}



}
