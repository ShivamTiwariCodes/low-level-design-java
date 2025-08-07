package designpatterns.mediatorDesignPattern.colleague;

import designpatterns.compositeDesignPattern.File;
import designpatterns.mediatorDesignPattern.mediator.ReservationMediator;

public class Passenger extends Component{

    private String name;

    public Passenger(ReservationMediator reservationMediator, String name) {
        super(reservationMediator);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void bookFlight(Flight flight) {
        this.reservationMediator.bookFlight(this, flight);
    }

    public void cancelSeat(Flight flight) {
        this.reservationMediator.cancelFlight(this, flight);
    }

    public void makePayment(int amount) {
        this.reservationMediator.makePayment(this, amount);
    }
}
