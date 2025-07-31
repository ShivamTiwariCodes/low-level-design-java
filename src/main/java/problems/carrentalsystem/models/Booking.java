package problems.carrentalsystem.models;

import problems.carrentalsystem.services.BookingService;
import problems.carrentalsystem.services.PaymentService;

import java.time.LocalDateTime;
import java.util.UUID;

public class Booking {

    private String bookingId;
    private String userId;
    private String carId;
    private DateRange dateRange;
    private BookingStatus bookingStatus;
    private LocalDateTime bookingTime;
    private Payment payment;

    public Booking(String userId, String carId, DateRange dateRange, Payment payment) {
        this.bookingId = UUID.randomUUID().toString();
        this.userId = userId;
        this.carId = carId;
        this.dateRange = dateRange;
        this.bookingStatus = BookingStatus.PAYMENT_PENDING;
        this.bookingTime = LocalDateTime.now();
        this.payment = payment;
    }

    public DateRange getDateRange() {
        return dateRange;
    }

    public String getUserId() {
        return userId;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getCarId() {
        return carId;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }



}
