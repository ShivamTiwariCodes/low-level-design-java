package designpatterns.stateDesignPattern.state;

import designpatterns.stateDesignPattern.Context;

public class StartState implements State{

    @Override
    public void goToStartState(Context context) {
        System.out.println("We are already on start state.");
    }

    @Override
    public void goToMidState(Context context) {
        System.out.println("Moving to mid state.");
        context.setState(new MidState());
    }

    @Override
    public void goToEndState(Context context) {
        System.out.println("We can't go to end state.");
    }

    @Override
    public String toString() {
        return "State state";
    }
}
