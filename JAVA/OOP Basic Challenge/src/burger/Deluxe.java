package burger;
public class Deluxe extends Burger {
    private String type;
    private double baconAmount;
    private String cheesType;
    private int pickledAmount;
    private int cheeseAmount;
    private double deluxePrice;

    public Deluxe() {
        super();
        this.type = "Deluxe";
        this.baconAmount = 4;
        this.cheesType = "chedar";
        this.cheeseAmount = 3;
        this.pickledAmount = 5;
        this.deluxePrice = 15.00;
        setBurgerPrice(deluxePrice);
    }
    @Override
    public String toString() {
        return """
                Deluxe Burger
                ----------------
                    2x beef meat
                    3x cheddar
                    4x bacon
                    5x pickles                                       
                """ +"\tprice "+ deluxePrice + "€";
    }
    @Override
    public void additionalBacon(double amount) {
        if (amount < 0) this.baconAmount = 1;
        baconAmount = (baconAmount + amount);
    }
    @Override
    public void additionalCheese(int cheese) {
        if (cheese < 0) cheeseAmount = 1;
        cheeseAmount = (cheeseAmount + cheese);
    }
    @Override
    public void setBurgerPrice(double burgerPrice) {
        super.setBurgerPrice(burgerPrice);
    }

    public double getDeluxePrice() {
        return deluxePrice;
    }
}
