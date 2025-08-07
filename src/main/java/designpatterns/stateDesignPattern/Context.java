package designpatterns.stateDesignPattern;

import designpatterns.stateDesignPattern.state.StartState;
import designpatterns.stateDesignPattern.state.State;

public class Context {

    private State state;

    public Context() {this.state = new StartState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
