package burger;

public class Cheesburger extends Burger {
    private String type;
    private double baconAmount;
    private String cheesType;
    private int pickledAmount;
    private int cheeseAmount;
    private double cheeseburgerPrice;

    public Cheesburger() {
        super();
        this.type = "Cheeseburger";
        this.baconAmount = 2;
        this.cheesType = "cheddar";
        this.cheeseAmount = 3;
        this.pickledAmount = 0;
        this.cheeseburgerPrice = 11.25;
        setBurgerPrice(cheeseburgerPrice);
    }
    @Override
    public String toString() {
        return """
                Cheeseburger Burger
                --------------------
                    2x beef meat
                    3x cheddar
                    2x bacon                                       
                """ +"\tprice "+ cheeseburgerPrice + "€";
    }
    @Override
    public void additionalBacon(double amount) {
        if (amount < 0) this.baconAmount = 1;
        baconAmount = (baconAmount + amount);
        cheeseburgerPrice = cheeseburgerPrice + (amount * super.baconPrice);
    }
    @Override
    public void additionalCheese(int cheese) {
        if (cheese < 0) cheeseAmount = 1;
        cheeseAmount = (cheeseAmount + cheese);
        cheeseburgerPrice = cheeseburgerPrice + (cheese * cheesePrice);
    }

    public double getCheeseburgerPrice() {
        return cheeseburgerPrice;
    }
}
