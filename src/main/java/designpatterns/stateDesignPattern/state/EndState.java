package designpatterns.stateDesignPattern.state;

import designpatterns.stateDesignPattern.Context;

import java.util.stream.Stream;

public class EndState implements State{

    @Override
    public void goToStartState(Context context) {
        System.out.println("Can't go to start state.");
    }

    @Override
    public void goToMidState(Context context) {
        System.out.println("Can't go to mid state.");
    }

    @Override
    public void goToEndState(Context context) {
        System.out.println("We are already on End state.");
    }

    @Override
    public String toString() {
        return "End state";
    }
}
