package problems.movieticketbookingsystem.models;

public class Seat {

    private String seatId;
    private SeatType seatType;
    private int price;

    public Seat(String seatId, SeatType seatType, int price) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.price = price;
    }

    public String getSeatId() {
        return seatId;
    }

    public int getPrice() {
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