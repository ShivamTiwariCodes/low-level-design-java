package designpatterns.mediatorDesignPattern;

import designpatterns.mediatorDesignPattern.colleague.Flight;
import designpatterns.mediatorDesignPattern.colleague.Passenger;
import designpatterns.mediatorDesignPattern.mediator.ReservationMediator;
import designpatterns.mediatorDesignPattern.mediator.ReservationSystem;


// Mediator design pattern is useful when you want to restrict multiple object communicating with each-other
// and want them to communicate through single channel, which is called mediator
// so this pattern need mediator and colleague to communicate

public class MediatorDesignPatternDemo {

    public void run() {

        ReservationMediator reservationMediator = new ReservationSystem();

        Flight flight1 = new Flight(reservationMediator, "FL-01", 2);
        Flight flight2 = new Flight(reservationMediator, "FL-02", 1);

        Passenger passenger1 = new Passenger(reservationMediator, "Pass-1");
        Passenger passenger2 = new Passenger(reservationMediator, "Pass-2");
        Passenger passenger3 = new Passenger(reservationMediator, "Pass-3");

        passenger1.bookFlight(flight1);
        passenger1.bookFlight(flight2);

        passenger2.bookFlight(flight1);
        passenger3.bookFlight(flight2);

        passenger2.cancelSeat(flight1);
        passenger3.bookFlight(flight1);

        passenger2.makePayment(5000);
        passenger3.makePayment(3000);


    }
}
