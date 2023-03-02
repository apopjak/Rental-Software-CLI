package burger;

public class Burger {
    private String type;
    protected double baconPrice;
    protected double cheesePrice;
    private double burgerPrice;
    private Classic classic;
    private Cheesburger cheesburger;
    private Deluxe deluxe;

    public Burger(String type) {
        this.type = type;
        this.baconPrice = 1.2;
        this.cheesePrice = 1.1;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "type='" + type + '\'' +
                ", baconPrice=" + baconPrice +
                ", cheesePrice=" + cheesePrice +
                ", burgerPrice=" + burgerPrice +
                ", classic=" + classic +
                ", cheeseburger=" + cheesburger +
                ", deluxe=" + deluxe +
                '}';
    }

    public static Burger orderBurger(String type) {
        return switch (type.toLowerCase().substring(0,3)) {
            case "cla"-> new Classic();
            case "che"-> new Cheesburger();
            case "del"-> new Deluxe();
            default -> new Classic();
        };

    }
    public Burger() {

    }
    public void setBurgerPrice(double burgerPrice) {
        this.burgerPrice = burgerPrice;
    }
    public double getBurgerPrice() {
        return burgerPrice;
    }
    public void additionalBacon(double amount){

    }
    public void additionalCheese(int cheese){

    }
}

