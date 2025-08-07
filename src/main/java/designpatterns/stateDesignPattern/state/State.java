package designpatterns.stateDesignPattern.state;

import designpatterns.stateDesignPattern.Context;

public interface State {

    public void goToStartState(Context context);
    public void goToMidState(Context context);
    public void goToEndState(Context context);
}
