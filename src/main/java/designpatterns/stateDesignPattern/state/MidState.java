package designpatterns.stateDesignPattern.state;

import designpatterns.stateDesignPattern.Context;

public class MidState implements State {

    @Override
    public void goToStartState(Context context) {
        System.out.println("Moving to start state.");
        context.setState(new StartState());
    }

    @Override
    public void goToMidState(Context context) {
        System.out.println("We are already on mid state.");
    }

    @Override
    public void goToEndState(Context context) {
        System.out.println("Moving to end state...");
        context.setState(new EndState());
    }

    @Override
    public String toString() {
        return "Mid state";
    }
}
