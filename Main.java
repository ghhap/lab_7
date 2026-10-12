
abstract class Vehicle {
    protected String brand;
    protected int year;

    public Vehicle() {
        this("Unknown", 2000);
    }

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void showInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }

    public abstract void start();
}

class Engine {
    private String type;
    private int power;

    public Engine() {
        this("Petrol", 100);
    }

    public Engine(String type, int power) {
        this.type = type;
        this.power = power;
    }

    public void showInfo() {
        System.out.println("Engine type: " + type);
        System.out.println("Power: " + power + " HP");
    }
}

interface Serviceable {
    void checkEngine();
}

class Car extends Vehicle implements Serviceable {
    private int doors;
    private Engine engine;

    public Car() {
        super();
        this.doors = 4;
        this.engine = new Engine();
    }

    public Car(String brand, int year, int doors,
               String engineType, int power) {
        super(brand, year);
        this.doors = doors;
        this.engine = new Engine(engineType, power);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Doors: " + doors);
        engine.showInfo();
    }

    @Override
    public void start() {
        System.out.println("Car is starting");
    }

    @Override
    public void checkEngine() {
        System.out.println("Engine checked successfully");
    }

    public void drive() {
        System.out.println("Car is driving");
    }

    public void drive(int speed) {
        System.out.println("Car speed: " + speed + " km/h");
    }
}

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car();
        System.out.println("Car 1:");
        car1.showInfo();
        car1.start();
        car1.checkEngine();

        System.out.println();

        Engine engine = new Engine("Diesel", 150);
        System.out.println("Engine:");
        engine.showInfo();

        System.out.println();

        Car car2 = new Car("Audi", 2022, 4, "Petrol", 250);
        System.out.println("Car 2:");
        car2.showInfo();
        car2.start();
        car2.checkEngine();
        car2.drive();
        car2.drive(90);

        System.out.println();

        Vehicle vehicle = new Car("Toyota", 2015, 4, "Diesel", 150);
        System.out.println("Vehicle:");
        vehicle.showInfo();
        vehicle.start();
    }
}
