package drink;

public class Juice extends Drink{
    private String name;
    private double price;
    private String size;

    public Juice(String size) {
        super("Juice");
        this.name = "Juice";
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
    public double getJuicePrice() {
        return price;
    }
}
