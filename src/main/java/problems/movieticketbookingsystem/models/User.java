package problems.movieticketbookingsystem.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;
    private String name;
    private List<Booking> bookings;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.bookings = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bookings=" + (bookings != null 
                    ? bookings.stream()
                        .map(booking -> booking.getId())
                        .toList() 
                    : "null") +
                '}';
    }

}