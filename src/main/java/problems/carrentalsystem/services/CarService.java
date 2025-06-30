package problems.carrentalsystem.services;

import problems.carrentalsystem.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarService {

    public static volatile CarService carServiceInstance;
    private final Map<String, Car> cars;

    private CarService() {
        this.cars = new ConcurrentHashMap<>();
    }

    public CarService getCarServiceInstance() {
        if(carServiceInstance == null) {
            synchronized (CarService.class) {
                if(carServiceInstance == null) {
                    carServiceInstance = new CarService();
                }
            }
        }
        return carServiceInstance;
    }

    public void addCar() {

    }

    public List<Car> getAvailableCars() {
        return new ArrayList<>();
    }






}
