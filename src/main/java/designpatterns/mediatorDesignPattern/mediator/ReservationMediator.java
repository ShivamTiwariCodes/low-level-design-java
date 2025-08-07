package designpatterns.mediatorDesignPattern.mediator;

import designpatterns.mediatorDesignPattern.colleague.Flight;
import designpatterns.mediatorDesignPattern.colleague.Passenger;

public interface ReservationMediator {
    void bookFlight(Passenger passenger, Flight flight);
    void cancelFlight(Passenger passenger, Flight flight);
    void makePayment(Passenger passenger, int amount);
}
