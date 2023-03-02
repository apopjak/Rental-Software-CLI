public class ElectricCar extends Car {
    private double avgKmPerCharge;


    public ElectricCar(String description, double avgKmPerCharge) {
        super(description);
        if (avgKmPerCharge < 0 ) avgKmPerCharge = 0;
        this.avgKmPerCharge = avgKmPerCharge;
    }

    public ElectricCar(String description) {
        super(description);
        this.avgKmPerCharge = 0;
    }

    @Override
    public void startEngine() {
        System.out.println("Whoooo Electric power has been started.");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Silently moving towards the target. ");
        if (avgKmPerCharge <= 0) {
            System.out.println("Unknown speed at the moment");
        } else {
            System.out.println("Electric speed is " + avgKmPerCharge);
        }
    }

}
