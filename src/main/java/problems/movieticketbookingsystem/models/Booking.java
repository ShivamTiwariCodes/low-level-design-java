package problems.movieticketbookingsystem.models;

import java.util.List;

import common.utils.TextUtil;

public class Booking {
    
    private String id;
    private User user;
    private List<Seat> seats;
    private Show show;
    private Payment payment;

    public Booking(User user, List<Seat> seats, Show show, Payment payment) {
        this.id = TextUtil.generateRandomText(14);
        this.user = user;
        this.seats = seats;
        this.show = show;
        this.payment = payment;
        user.addBooking(this);
    }
    
    public Payment getPayment() {
        return payment;
    }

    public void pay() {
        this.payment.pay();
        for(Seat seat: seats) {
            show.updateSeatStatus(seat, SeatStatus.BOOKED);
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Show getShow() {
        return show;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", user=" + (user != null ? user.toString() : "null") +
                ", seats=" + (seats != null 
                    ? seats.stream().map(Seat::getSeatId).toList()
                    : "null") +
                ", show=" + (show != null ? show.toString() : "null") +
                ", payment=" + (payment != null 
                    ? payment.toString()
                    : "null") +
                '}';
    }
    
}
