package sideDish;

public class SideDish {
    private String type;
    private double sideDishPrice;

    public SideDish(String type) {
        this.type = type;
        this.sideDishPrice = 0;
    }
    public static SideDish orderSideDish(String type, String size) {
        return switch (type.toLowerCase().charAt(0)) {
            case 'f'-> new Fries(size);
            case 'o'-> new Onions(size);
            case 'c'-> new CheeseNuggets(size);
            default -> new Fries("medium");
        };
    }

    public double getSideDishPrice() {
        return sideDishPrice;
    }

    public void setSideDishPrice(double sideDishPrice) {
        this.sideDishPrice = sideDishPrice;
    }
}
