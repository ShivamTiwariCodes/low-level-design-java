package designpatterns.stateDesignPattern;

import designpatterns.stateDesignPattern.state.State;

public class StateDesignPatternDemo {

    public void run() {

        Context context = new Context();
        System.out.println("Expected is start state. Actual state is : " + context.getState().toString());

        State state = context.getState();
        state.goToMidState(context);
        System.out.println("Expected is Mid state. Actual state is : " + context.getState().toString());

        state = context.getState();
        state.goToStartState(context);
        System.out.println("Expected is start state. Actual state is : " + context.getState().toString());

        state = context.getState();
        state.goToEndState(context);
        System.out.println("Expected is start state. Actual state is : " + context.getState().toString());


        state.goToMidState(context);
        System.out.println("Expected is mid state. Actual state is : " + context.getState().toString());

        state = context.getState();
        state.goToEndState(context);
        System.out.println("Expected is end state. Actual state is : " + context.getState().toString());

        state = context.getState();
        state.goToMidState(context);
        System.out.println("Expected is end state. Actual state is : " + context.getState().toString());

        state = context.getState();
        state.goToStartState(context);
        System.out.println("Expected is end state. Actual state is : " + context.getState().toString());
    }
}
