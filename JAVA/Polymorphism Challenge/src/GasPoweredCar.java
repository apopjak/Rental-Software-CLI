public class GasPoweredCar extends Car{
    private double avgKmPerCharge;

    public GasPoweredCar(String description, double avgKmPerCharge) {
        super(description);
        if (avgKmPerCharge < 0 ) avgKmPerCharge = 0;
        this.avgKmPerCharge = avgKmPerCharge;
    }

    public GasPoweredCar(String description) {
        super(description);
        this.avgKmPerCharge = 0;
    }

    @Override
    public void startEngine() {
        System.out.println("brom brom brom brom...diesel");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Loudly moving towards the target. ");
        if (avgKmPerCharge <= 0) {
            System.out.println("Unknown speed at the moment");
        } else {
            System.out.println("Speed is " + avgKmPerCharge);
        }
    }
}
