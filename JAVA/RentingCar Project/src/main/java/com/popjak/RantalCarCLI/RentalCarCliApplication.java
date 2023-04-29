package com.popjak.RantalCarCLI;

import com.popjak.RantalCarCLI.Car.Car;
import com.popjak.RantalCarCLI.Car.CarService;
import com.popjak.RantalCarCLI.User.User;
import com.popjak.RantalCarCLI.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class RentalCarCliApplication {

	private final UserService userService;
	private final CarService carService;

	@Autowired
	public RentalCarCliApplication(UserService userService, CarService carService) {
		this.userService = userService;
		this.carService = carService;
	}


	public static void main(String[] args) {
		SpringApplication.run(RentalCarCliApplication.class, args);
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
        
					-------------------------------------
					1️⃣ --> Book a car                   |
					-------------------------------------						   
					2️⃣ --> View available electric cars *  |
					3️⃣ --> View available hybrid cars  *   |
					4️⃣ --> View available petrol cars *  |
					-------------------------------------	   
					5️⃣ --> View all bookings            |
					6️⃣ --> View all user booked cars    |
					7️⃣ --> View all users      *          |
					8️⃣ --> Register new user    *        |
					-------------------------------------	   
					0️⃣ --> Exit                         |
					-------------------------------------
					hviezdicky vymazat na konci reprezentuju co uz je spravene na 100%
					""";

			System.out.println(message);
			String input = scanner.nextLine();

			switch (input) {
				default -> System.out.println("Wrong Input try again ❌");
				case "0" -> {
					System.out.println("Dakujeme dovidenia");
					program = false;
				}
				case "1" -> {
					System.out.println("--------- Book a car -------------------------------------");
					Car car1 = new Car("PP253X2", "Hummer", "h1","1991","21","Petrol");

					carService.insertToDB(car1);

				}
				case "2" ->
				{
					System.out.println("--------- View available ELECTRIC cars -------------------------------------");
					carService.showAllElectricCars();
				}
				case "3" -> {
					System.out.println("--------- View available HYBRID cars -------------------------------------");
					carService.showAllHybridCars();
				}
				case "4" -> {
					System.out.println("--------- View available PETROL cars -------------------------------------");
					carService.showAllPetrolCars();
				}
				case "5" -> {
					System.out.println("--------- View all bookings -------------------------------------");
					System.out.println("5");
				}
				case "6" -> {
					System.out.println("--------- View all user booked cars -------------------------------------");
					System.out.println("6");
				}
				case "7" -> {
					System.out.println("--------- List of users ---------------------------");
					userService.showAllUsers();
				}
				case "8" -> {

					System.out.println("--------- User registration ----------------------");


					System.out.print("First name: ");
					String firstName = titleCase(scanner.nextLine());

					System.out.print("Last name: ");
					String lastName = titleCase(scanner.nextLine());

					System.out.print("Email address: ");
					String email = scanner.nextLine().toLowerCase();
					if (!email.contains("@")) {
						System.out.println(" >>> Wrong email format ❌");
					} else {
						User user = new User(firstName,lastName,email);
						userService.registerUser(user);
					}
				}
			}
		}
	}

	private static String titleCase(String string) {
		return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
	}


}
