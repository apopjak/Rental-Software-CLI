public class Car {

    private String description;

    public Car(String description) {
        this.description = description;
    }
    public void startEngine(){
        System.out.println("Engine has been started.");
    }
    public static Car typeOfCar(String description){
        return switch (description.toLowerCase().charAt(0)) {
            case 'e' -> new ElectricCar(description);
            case 'g' -> new GasPoweredCar(description);
            case 'h' -> new HybridCar(description);
            default -> new Car(description);
        };
    }

    public void drive() {
        System.out.println("Vehicle is moving");
        runEngine();

    }
    private void runEngine(){
        System.out.println("Engine is running");
    }

}
