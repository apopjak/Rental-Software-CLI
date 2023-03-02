import burger.Burger;
import drink.Drink;
import sideDish.SideDish;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String logo = """
               
                 ____  _ _ _ _         ____                            _    _                     \s
                |  _ \\(_) | ( )       |  _ \\                          | |  | |                    \s
                | |_) |_| | |/ ___    | |_) |_   _ _ __ __ _  ___ _ __| |__| | ___  _   _ ___  ___\s
                |  _ <| | | | / __|   |  _ <| | | | '__/ _` |/ _ \\ '__|  __  |/ _ \\| | | / __|/ _ \\
                | |_) | | | | \\__ \\   | |_) | |_| | | | (_| |  __/ |  | |  | | (_) | |_| \\__ \\  __/
                |____/|_|_|_| |___/   |____/ \\__,_|_|  \\__, |\\___|_|  |_|  |_|\\___/ \\__,_|___/\\___|
                                                        __/ |                                     \s
                                                       |___/                                      \s
                              
                """;
        System.out.println(logo);
        System.out.print("Welcome, would you like to order something please? ");
        String start = scanner.next().toLowerCase();
        if (start.equals("yes")) {
            while (start.equals("yes")){
                newOrder();
                System.out.print("Do you want do create another order? ");
                start = scanner.next();
            }
        }
    }
    private static void  newOrder() {
        /**
         *  New order takes users input and based on that creates an order from OOP
         *
         * **/
        Scanner scanner = new Scanner(System.in);

        // GETTING BURGER ORDER
        System.out.print("What burger would you like to have: \n\nClassic: 12.4€ \nCheeseburger 11.25€\nDELUXE 15.00€   ");
        String burgerChoice = scanner.nextLine().toLowerCase();
        Burger burger = Burger.orderBurger(burgerChoice);





        // GETTING DRINK AND SIZE
        System.out.print("What drink do you want? 'Cola', 'Fanta', 'Juice': ");
        String drinkSelection = scanner.nextLine();
        System.out.print("What size of drink? 'large', 'medium', 'small?': ");
        String drinkSize = scanner.nextLine();
        Drink drink = Drink.orderDrink(drinkSelection,drinkSize);




        // GETTING SIDE DISHES
        System.out.print("What about side dish? 'Fries', 'Onions', 'Cheese-nuggets': ");
        String sideDishSelection = scanner.nextLine();
        System.out.print("What size? 'large', 'medium', 'small?': ");
        String sideDishSize = scanner.nextLine();
        SideDish sideDish = SideDish.orderSideDish(sideDishSelection,sideDishSize);

        MealOrder menu = new MealOrder(burger,drink,sideDish);

        System.out.println(menu);

    }
}