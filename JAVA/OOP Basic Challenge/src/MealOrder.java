import burger.Burger;
import drink.Drink;
import sideDish.SideDish;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MealOrder {
    private Burger burger;
    private Drink drink;
    private SideDish sideDish;

    public MealOrder() {
        burger = Burger.orderBurger("Classic");
        drink = Drink.orderDrink("Cola", "medium");
        sideDish = SideDish.orderSideDish("Fries", "medium");
    }

    public MealOrder(Burger burger, Drink drink, SideDish sideDish) {
        this.burger = burger;
        this.drink = drink;
        this.sideDish = sideDish;
    }

    @Override
    public String toString() {
        return "Your menu:\n" +
                burger.toString() + "\n" +
                drink.toString() + "\n\n" +
                sideDish.toString() + "\n\nTotal price "+ getFinalPrice() + "€" ;
    }
    public double getFinalPrice(){
        return Math.round((burger.getBurgerPrice() + sideDish.getSideDishPrice() + drink.getDrinkPrice()));
    }
}
