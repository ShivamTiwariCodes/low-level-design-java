package problems.carrentalsystem.services;


import problems.carrentalsystem.models.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class BookingService {

    private static String DEFAULT_FORMAT = "";

    private static volatile BookingService bookingServiceInstance;
    private PaymentService paymentService;
    private Map<String, CopyOnWriteArrayList<Booking>> userBookingsMap;
    private Map<String, CopyOnWriteArrayList<Booking>> carBookingsMap;

    private BookingService() {
        this.paymentService = PaymentService.getInstance();
        this.userBookingsMap = new ConcurrentHashMap<>();
        this.carBookingsMap = new ConcurrentHashMap<>();
    }

    public static BookingService getBookingServiceInstance() {
        if(bookingServiceInstance == null) {
            synchronized (BookingService.class) {
                if(bookingServiceInstance == null) {
                    bookingServiceInstance = new BookingService();
                }
            }
        }
        return bookingServiceInstance;
    }

    public synchronized void book(User user, Car car, IPaymentStrategy paymentStrategy, DateRange dateRange) {
        int days = dateRange.getDays();
        BigDecimal totalCost = car.getPricePerDay().multiply(new BigDecimal(days));
        Payment payment = paymentService.pay(paymentStrategy, totalCost);
        Booking booking = new Booking(user.getId(), car.getId(), dateRange, payment);
        addUserBooking(user.getId(), booking);
        addCarBooking(car.getId(), booking);
    }

    public void addUserBooking(String userId, Booking booking) {
        userBookingsMap.putIfAbsent(userId, new CopyOnWriteArrayList<>());
        userBookingsMap.get(userId).add(booking);
    }

    public void addCarBooking(String carId, Booking booking) {
        carBookingsMap.putIfAbsent(carId, new CopyOnWriteArrayList<>());
        carBookingsMap.get(carId).add(booking);
    }


    public List<Booking> getCarBooking(String carId) {
        return carBookingsMap.getOrDefault(carId, new CopyOnWriteArrayList<>());
    }
}
