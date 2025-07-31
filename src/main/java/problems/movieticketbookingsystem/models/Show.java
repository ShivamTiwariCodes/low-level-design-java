package problems.movieticketbookingsystem.models;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Show {

    private String id;
    private Movie movie;
    private Instant startTime;
    private Screen screen;
    private ConcurrentHashMap<Seat, SeatStatus> bookingMap;

    public Show(String id, Movie movie, Instant startTimeInstant, Screen screen) {
        this.id = id;
        this.movie = movie;
        this.startTime = startTimeInstant;
        this.screen = screen;
        bookingMap = new ConcurrentHashMap<>();
        for(Seat seat: screen.getSeats()) {
            bookingMap.put(seat, SeatStatus.AVAILABLE);
        }
    }

    public SeatStatus getSeatStatus(Seat seat) {
        return bookingMap.get(seat);
    }

    public Screen getScreen() {
        return screen;
    }

    public Instant getStarTime() {
        return startTime;
    }

    public List<Seat> getAvailableSeats() {
        return bookingMap.entrySet().stream()
        .filter(entry -> entry.getValue().equals(SeatStatus.AVAILABLE))
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
    }

    public List<Seat> getAvailableSeats(SeatType seatType, int count) {
        List<Seat> availavleSeats = bookingMap.entrySet().stream()
        .filter(entry -> entry.getValue().equals(SeatStatus.AVAILABLE))
        .filter(entry -> entry.getKey().getSeatType().equals(seatType))
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
        return availavleSeats.subList(0, Math.min(availavleSeats.size(), count));
    }

    public BigDecimal blockSeatsAndGetAmount(List<Seat> seats) {
        for(Seat seat: seats) {
            bookingMap.put(seat, SeatStatus.BLOCKED);
        }
         return seats.stream()
                .map(Seat::getPrice)
                .reduce((a, b) -> (a.add(b))).get();
    }

    public void updateSeatStatus(Seat seat, SeatStatus seatStatus) {
        bookingMap.put(seat, seatStatus);
    }

    @Override
    public String toString() {
        return "Show{" +
                "id='" + id + '\'' +
                ", movie=" + (movie != null ? movie.toString() : "null") +
                ", startTime=" + startTime +
                ", screen=" + (screen != null ? screen.toString() : "null") +
                ", bookingMap=" + bookingMap.entrySet().stream()
                    .map(entry -> entry.getKey().getSeatId() + "=" + entry.getValue())
                    .toList() +
                '}';
    }
    
    

}