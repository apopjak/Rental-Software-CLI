package com.popjak.RentalCarCLI;

import com.popjak.RentalCarCLI.adminMenu.*;
import com.popjak.RentalCarCLI.mainMenu.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class AdminMenu {

	private final ShowUserByEmail showUserByEmail;
	private final ViewAllUsers viewAllUsers;
	private final ViewAvailableCars viewAvailableCars;
	private final RegisterCar registerCar;
	private final RemoveCarFromDB removeCarFromDB;

	@Autowired
	public AdminMenu(ShowUserByEmail showUserByEmail, ViewAllUsers viewAllUsers, ViewAvailableCars viewAvailableCars,
					 RegisterCar registerCar, RemoveCarFromDB removeCarFromDB) {
		this.showUserByEmail = showUserByEmail;
		this.viewAllUsers = viewAllUsers;
		this.viewAvailableCars = viewAvailableCars;
		this.registerCar = registerCar;
		this.removeCarFromDB = removeCarFromDB;
	}


	public void admin() {

		Scanner scanner = new Scanner(System.in);
		boolean adminProgram = true;
		while (adminProgram) {

			String message = """
				-----------------------------------|
				----------- ADMIN MOD--------------|
				-----------------------------------|
				🔸 2️⃣ --> View all bookings        
				🔸 3️⃣ --> View user booked cars    
				🔸 4️⃣ --> View all users           
				🔸 5️⃣ --> Find user by email       
				-----------------------------------|					            
				🔸 6️⃣ --> Register car into DB     
				🔸 7️⃣ --> Remove Car from DB       
				🔸                                 
				🔸 8️⃣ --> View All Cars            
				-----------------------------------|
				🔸 9️⃣ --> Main Menu                
				🔸 0️⃣ --> Exit Admin Mode                   
				-----------------------------------|		
			
					""";

			System.out.println(message);
			String input = scanner.nextLine();

			switch (input) {
				default -> System.out.println("Wrong Input try again ❌");
				case "0", "9" -> {
					adminProgram = false;
				}

				case "2" -> {
					System.out.println("--------- View all bookings  -------------------------------------");


				}
				case "3" -> {
					System.out.println("--------- View user booked cars   -------------------------------------");

				}
				case "4" -> {
					System.out.println("--------- View all users   -------------------------------------");
					viewAllUsers.listAllUsers();
				}
				case "5" -> {
					System.out.println("--------- Find user by email  -------------------------------------");
					showUserByEmail.showUserSelectedByEmail();
				}
				case "6" -> {
					System.out.println("--------- Register car into DB  -------------------------------------");
					registerCar.registerNewCarIntoDB();
				}
				case "7" -> {
					System.out.println("--------- Remove Car from DB   -------------------------------------");
					removeCarFromDB.removeCar();
				}
				case "8" -> {
					System.out.println("--------- View All Cars   -------------------------------------");
					viewAvailableCars.showAllCars();
				}

			}
		}
	}
}

