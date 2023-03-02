public class HybridCar extends Car{
    private double avgKmPerCharge;

    public HybridCar(String description, double avgKmPerCharge) {
        super(description);
        if (avgKmPerCharge < 0 ) avgKmPerCharge = 0;
        this.avgKmPerCharge = avgKmPerCharge;
    }

    public HybridCar(String description) {
        super(description);
        this.avgKmPerCharge = 0;
    }
    @Override
    public void startEngine() {
        System.out.println("Brom BROM and Electric power has been started. HYBRIIIIID");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Hybrid is moving towards the target. ");
        if (avgKmPerCharge <= 0) {
            System.out.println("Unknown speed at the moment");
        } else {
            System.out.println("Electric/Gas speed is " + avgKmPerCharge);
        }
    }
}
