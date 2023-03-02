package sideDish;

public class Onions extends SideDish{
    private String name;
    private double price;
    private String size;

    public Onions(String size) {
        super("Onions");
        this.name = "Onions";
        switch (size.toLowerCase().charAt(0)) {
            case 'l'-> this.size = "Large";
            case 's'-> this.size = "Small";
            case 'm'-> this.size = "Medium";
            default -> this.size = "Medium";
        }
        if (this.size.equals("Large")){
            this.price = 3.89;
        } else if (this.size.equals("Small")) {
            this.price = 2.89;
        } else {
            this.price = 3.35;
        }
        setSideDishPrice(this.price);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + "\n------------" +
                "\n\tsize: " + size +
                "\n\tprice: " + price + "€";
    }
    public double getPrice() {
        return price;
    }
}
