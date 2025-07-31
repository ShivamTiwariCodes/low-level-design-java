package problems.movieticketbookingsystem.models;

import java.math.BigDecimal;

public class Seat {

    private String seatId;
    private SeatType seatType;
    private BigDecimal price;

    public Seat(String seatId, SeatType seatType, BigDecimal price) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.price = price;
    }

    public String getSeatId() {
        return seatId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId='" + seatId + '\'' +
                ", seatType=" + seatType +
                ", price=" + price +
                '}';
    }

}