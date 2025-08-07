package designpatterns.mediatorDesignPattern.colleague;

import designpatterns.mediatorDesignPattern.mediator.ReservationMediator;

public class Flight extends Component{

    private String flightId;
    private int availableSeats;

    public Flight(ReservationMediator reservationMediator, String flightId, int availableSeats) {
        super(reservationMediator);
        this.flightId = flightId;
        this.availableSeats = availableSeats;
    }

    public void bookSeat(Passenger passenger) {
        if(isSeatAvailable()) {
            availableSeats--;
            System.out.println("Seat is booked for passenger : " + passenger.getName() + " in flight with ID : " + flightId);
        } else {
            System.out.println("Seat booking for " + passenger.getName() + " is failed. No seat seat is available in flight with flightId : " + flightId);
        }
    }

    public boolean isSeatAvailable() {
        if(availableSeats>0) return true;
        return false;
    }

    public void cancelSeat(Passenger passenger) {
        availableSeats++;
        System.out.println("Seat is cancelled for passenger + " + passenger.getName() + " in flight of flightId + " + flightId);
    }




}
