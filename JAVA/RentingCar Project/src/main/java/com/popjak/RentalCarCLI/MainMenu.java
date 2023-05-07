package com.popjak.RentalCarCLI;

import com.popjak.RentalCarCLI.mainMenu.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

import java.util.*;

@SpringBootApplication(scanBasePackages = {"com.popjak.RentalCarCLI"})
public class MainMenu {

	// Dependencies
	private final ViewAvailableCars viewAvailableCars;
	private final RegisterUser registerUser;
	private final AdminMenu adminMenu;

	public MainMenu(ViewAvailableCars viewAvailableCars, RegisterUser registerUser, AdminMenu adminMenu) {
		this.viewAvailableCars = viewAvailableCars;
		this.registerUser = registerUser;
		this.adminMenu = adminMenu;
	}

	public static void main(String[] args) {
		SpringApplication.run(MainMenu.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> {
			mainProgram();
			System.out.println();
		};
	}

	private void mainProgram() {

		Scanner scanner = new Scanner(System.in);
		boolean program = true;
		while (program) {

			String message = """
    
    
				------------------------------------
				------------ MAIN MENU -------------
				------------------------------------					
				1️⃣ --> Book a car                   |
				-------------------------------------
				2️⃣ --> View available electric cars |
				3️⃣ --> View available hybrid cars   |
				4️⃣ --> View available petrol cars   |
				5️⃣ --> View ALL cars                |
				----------------------------------- |					            
				6️⃣ --> Register new account         |
				------------------------------------
				9️⃣ --> Admin Menu                   |
				0️⃣ --> Exit                         |
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
					System.out.println("--------- Book a car -------------------------------------");
					System.out.println("enter your userID (email address): ");


					// 1. ask for email
					// 2. validate email, if email exists continue if not error message
					// 3. from what price range car user wants to pick
					// 4. show all cars in that price range which are available
					// if car already in booking DB do not show it
					// 5. ask how many days rent is for
					// 6. show final price including deposit
					// add to database

					//TODO asi bude lepsie rozdelit tuto hlavnu stranu na extra package a potom na mensie classes
					// ktore len spojim dokopy


				}
				case "2" -> {
					System.out.println("--------- View available ELECTRIC cars -------------------------------------");
					viewAvailableCars.showCarBasedOnEngine("Electric");

				}
				case "3" -> {
					System.out.println("--------- View available HYBRID cars -------------------------------------");
					viewAvailableCars.showCarBasedOnEngine("Hybrid");
				}
				case "4" -> {
					System.out.println("--------- View available PETROL cars -------------------------------------");
					viewAvailableCars.showCarBasedOnEngine("Petrol");
				}
				case "5" -> {
					System.out.println("--------- View ALL available cars -------------------------------------");
					viewAvailableCars.showAllCars();
				}
				case "6" -> {
					System.out.println("--------- Register new account -------------------------------------");
					registerUser.registerNewUser();
				}

				case "9" -> {
					adminMenu.admin();
				}
			}
		}
	}
}

