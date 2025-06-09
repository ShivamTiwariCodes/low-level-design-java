package problems.movieticketbookingsystem.service;

import java.util.List;

import problems.movieticketbookingsystem.models.Booking;
import problems.movieticketbookingsystem.models.IPaymentStrategy;
import problems.movieticketbookingsystem.models.Payment;
import problems.movieticketbookingsystem.models.Seat;
import problems.movieticketbookingsystem.models.SeatStatus;
import problems.movieticketbookingsystem.models.Show;
import problems.movieticketbookingsystem.models.User;

public class BookingService {

    private static  BookingService bookingService;

    private BookingService() {}

    public static BookingService getInstance() {
        if(bookingService == null) {
            synchronized (BookingService.class) {
                if(bookingService == null) {
                    bookingService = new BookingService();
                }
            }
        }
        return bookingService;
    }

    public synchronized Booking bookSeats(User user, Show show, List<Seat> seats, IPaymentStrategy paymentStrategy) {
        boolean isAnySeatNotAvailable = seats.stream().anyMatch(s -> !show.getSeatStatus(s).equals(SeatStatus.AVAILABLE));
        if(isAnySeatNotAvailable) return new Booking(null, null, null, null);
        int amount = show.blockSeatsAndGetAmount(seats);
        Booking booking = new Booking(user, seats, show, new Payment(user, amount, paymentStrategy));
        return booking;
    }
}