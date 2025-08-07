package designpatterns.mediatorDesignPattern.mediator;

import designpatterns.mediatorDesignPattern.colleague.Flight;
import designpatterns.mediatorDesignPattern.colleague.Passenger;

public class ReservationSystem implements ReservationMediator{

    @Override
    public void bookFlight(Passenger passenger, Flight flight) {
        flight.bookSeat(passenger);
    }

    @Override
    public void cancelFlight(Passenger passenger, Flight flight) {
        flight.cancelSeat(passenger);
    }

    @Override
    public void makePayment(Passenger passenger, int amount) {
        System.out.println("Payment is successful for amount " + amount);
    }
}
