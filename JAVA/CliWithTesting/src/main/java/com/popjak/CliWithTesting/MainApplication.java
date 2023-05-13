package com.popjak.CliWithTesting;


import com.popjak.CliWithTesting.car.carSubServices.*;
import com.popjak.CliWithTesting.user.userSubServices.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

import java.util.*;

@SpringBootApplication
public class MainApplication {

	@Autowired
	CarRegistration carRegistration;

	@Autowired
	CarDelete carDelete;

	@Autowired
	CarUpdate carUpdate;
	@Autowired
	ViewAllCars viewAllCars;

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
    
    
				------------------------------------
				------------ MAIN MENU -------------
				------------------------------------					
				                |
				-------------------------------------
				1 --> Car Registration
				2 --> View All cars
				3 --> Car update
				4 --> Car remove
				----------------------------------- |					            
				        |
				------------------------------------
				                  |
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
					System.out.println("--------- Car registration -------------------------------------");
					carRegistration.carRegistration();
				}
				case "2" -> {
					System.out.println("--------- View All cars -------------------------------------");
					viewAllCars.viewAllCars();
				}
				case "3" -> {
					System.out.println("--------- Car update -------------------------------------");
					carUpdate.carUpdate();
				}
				case "4" -> {
					System.out.println("--------- Car delete -------------------------------------");
					carDelete.carDelete();
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


}}
