package drink;

public class Drink {
    private String name;
    private double drinkPrice;

    public Drink(String name) {
        this.name = name;
    }

    public static Drink orderDrink(String type, String size) {
        return switch (type.toLowerCase().charAt(0)) {
            case 'c'-> new Cola(size);
            case 'f'-> new Fanta(size);
            case 'j'-> new Juice(size);
            default -> new Cola("Medium");
        };
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }
}
