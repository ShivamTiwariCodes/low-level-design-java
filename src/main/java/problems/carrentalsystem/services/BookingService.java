package problems.carrentalsystem.services;

import problems.carrentalsystem.models.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BookingService {

    // Eager initialization singleton for thread safety and simplicity
    private static final BookingService bookingServiceInstance = new BookingService();

    private final PaymentService paymentService;
    // Map userId -> synchronized list of bookings
    private final Map<String, List<Booking>> userBookingsMap;
    // Map carId -> synchronized list of bookings
    private final Map<String, List<Booking>> carBookingsMap;

    // Per-car locks to synchronize booking operations on the same car
    private final Map<String, Object> carLocks;

    private BookingService() {
        this.paymentService = PaymentService.getInstance();
        this.userBookingsMap = new ConcurrentHashMap<>();
        this.carBookingsMap = new ConcurrentHashMap<>();
        this.carLocks = new ConcurrentHashMap<>();
    }

    public static BookingService getBookingServiceInstance() {
        return bookingServiceInstance;
    }

    /**
     * Attempts to book a car for a user during the given date range.
     * Returns true if booking succeeds, false if car is already booked in that range.
     */
    public boolean book(User user, Car car, IPaymentStrategy paymentStrategy, DateRange dateRange) {
        Object carLock = carLocks.computeIfAbsent(car.getId(), k -> new Object());

        synchronized (carLock) {
            // Check for conflicting bookings before proceeding
            List<Booking> existingBookings = carBookingsMap.getOrDefault(car.getId(),
                    Collections.synchronizedList(new ArrayList<>()));
            if (isBookingConflicting(existingBookings, dateRange)) {
                // Car is already booked for overlapping date range
                return false;
            }

            // Calculate total cost
            int days = dateRange.getDays();
            BigDecimal totalCost = car.getPricePerDay().multiply(new BigDecimal(days));

            // Proceed with payment
            Payment payment = paymentService.pay(paymentStrategy, totalCost);
            payment.pay();

            // Create new booking and mark confirmed
            Booking booking = new Booking(user.getId(), car.getId(), dateRange, payment);
            booking.setBookingStatus(BookingStatus.CONFIRMED);

            // Add booking to userBookingsMap with synchronized list
            userBookingsMap.putIfAbsent(user.getId(), Collections.synchronizedList(new ArrayList<>()));
            userBookingsMap.get(user.getId()).add(booking);

            // Add booking to carBookingsMap similarly
            carBookingsMap.putIfAbsent(car.getId(), Collections.synchronizedList(new ArrayList<>()));
            carBookingsMap.get(car.getId()).add(booking);

            // Booking successful
            return true;
        }
    }

    private boolean isBookingConflicting(List<Booking> bookings, DateRange dateRange) {
        synchronized (bookings) {
            for (Booking booking : bookings) {
                if (booking.getBookingStatus() == BookingStatus.CONFIRMED &&
                        booking.getDateRange().isColliding(dateRange)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns a defensive copy of car bookings to avoid exposing internal collections.
     */
    public List<Booking> getCarBooking(String carId) {
        List<Booking> bookings = carBookingsMap.get(carId);
        if (bookings == null) return Collections.emptyList();

        synchronized (bookings) {
            return new ArrayList<>(bookings);
        }
    }

    /**
     * Returns a defensive copy of bookings by user.
     */
    public List<Booking> getBookingsByUserId(String userId) {
        List<Booking> bookings = userBookingsMap.get(userId);
        if (bookings == null) return Collections.emptyList();

        synchronized (bookings) {
            return new ArrayList<>(bookings);
        }
    }
}
