package drink;

public class Cola extends Drink{
    private String name;
    private double price;
    private String size;

    public Cola(String size) {
        super("Cola");
        this.name = "Cola";
        switch (size.toLowerCase().charAt(0)) {
            case 'l'-> this.size = "Large";
            case 's'-> this.size = "Small";
            case 'm'-> this.size = "Medium";
            default -> this.size = "Medium";
        }
        if (this.size.equals("Large")){
            this.price = 4.0;
        } else if (this.size.equals("Medium")) {
            this.price = 3.50;
        } else {
            this.price = 2.99;
        }
        super.setDrinkPrice(price);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "\n------------" +
                "\n\tsize: " + size +
                "\n\tprice: " + price + "€";
    }

    public double getColaPrice() {
        return price;
    }
}
