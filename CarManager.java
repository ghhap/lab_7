import java.util.Arrays;
import java.util.Comparator;

public class CarManager {
    private Car[] cars;

    public CarManager() {
        cars = new Car[]{
                new Car("Toyota", "Camry", 2020, 25000),
                new Car("BMW", "X5", 2022, 65000),
                new Car("Audi", "A4", 2019, 28000),
                new Car("Mercedes", "C200", 2021, 45000),
                new Car("Honda", "Civic", 2018, 18000),
                new Car("Ford", "Focus", 2017, 12000),
                new Car("Volkswagen", "Passat", 2020, 23000),
                new Car("Hyundai", "Elantra", 2023, 22000),
                new Car("Kia", "Sportage", 2022, 30000),
                new Car("Tesla", "Model 3", 2023, 40000)
        };
    }

    public void showAll() {
        for (int i = 0; i < cars.length; i++) {
            System.out.println(i + ". " + cars[i]);
        }
    }

    public void editCar(int index, String brand, String model,
                        int year, double price) {
        if (index >= 0 && index < cars.length) {
            cars[index].update(brand, model, year, price);
            System.out.println("Автомобіль змінено!");
        } else {
            System.out.println("Неправильний індекс!");
        }
    }

    public void showExpensiveCars(double minPrice) {
        for (Car car : cars) {
            if (car.getPrice() > minPrice) {
                System.out.println(car);
            }
        }
    }

    public void sortAscending() {
        Arrays.sort(cars, Comparator.comparingDouble(Car::getPrice));
        System.out.println("Сортування за зростанням ціни:");
        showAll();
    }

    public void sortDescending() {
        Arrays.sort(cars,
                Comparator.comparingDouble(Car::getPrice).reversed());
        System.out.println("Сортування за спаданням ціни:");
        showAll();
    }
}