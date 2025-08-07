package designpatterns.mediatorDesignPattern.colleague;

import designpatterns.mediatorDesignPattern.mediator.ReservationMediator;

public abstract class Component {

    protected ReservationMediator reservationMediator;

    public Component(ReservationMediator reservationMediator) {
        this.reservationMediator = reservationMediator;
    }
}
