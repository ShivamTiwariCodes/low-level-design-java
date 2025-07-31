package problems.carrentalsystem.services;

import problems.carrentalsystem.models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarService {

    public static volatile CarService carServiceInstance;
    private final Map<String, Car> cars;
    private Cache cache;

    private CarService() {
        this.cars = new ConcurrentHashMap<>();
        this.cache = Cache.getInstance();
    }

    public static CarService getCarServiceInstance() {
        if(carServiceInstance == null) {
            synchronized (CarService.class) {
                if(carServiceInstance == null) {
                    carServiceInstance = new CarService();
                }
            }
        }
        return carServiceInstance;
    }

    public void addCar(Car car) {
        cars.putIfAbsent(car.getId(), car);
    }

    public void printAvailableCars(List<Car> availableCars) {
        System.out.println("Available cars are : ");
        for(Car car: availableCars) {
            System.out.print(car.getId() + " , ");
        }
    }

    public List<Car> getAvailableCars(Filter filter) {
        List<Car> availableCars = new ArrayList<>();
        BookingService bookingService = BookingService.getBookingServiceInstance();
        for(Car car: cars.values()) {
            List<Booking> bookings = bookingService.getCarBooking(car.getId());
            if(isBookingConflicting(bookings, filter.getDateRange())) {

            }
        }


        System.out.println("Applied filters : " + filter.toString());
        return new ArrayList<>();
    }

    public boolean isBookingConflicting(List<Booking> bookings, DateRange dateRange) {
        for(Booking booking: bookings) {
            if(booking.getBookingStatus() == BookingStatus.CONFIRMED && booking.getDateRange().isColliding(dateRange)) {
                return true;
            }
        }

        return false;
    }






}
