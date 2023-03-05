package com.popjak.menu;

import java.util.Scanner;

public class menu {

    public static void mainMenu() {
        String input;
        String mainMenu = """
                1️⃣ - Book Car
                2️⃣ - View All User Booked Cars
                3️⃣ - View All Bookings
                4️⃣ - View Available Cars
                5️⃣ - View Available Electric Cars
                6️⃣ - View All users
                7️⃣ - Exit
                
                0️⃣ - Add Car to Database (only admin)
                """;


        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(mainMenu);
            input = sc.nextLine();
            if (input.equals("7")) break;
        }
    }
}
