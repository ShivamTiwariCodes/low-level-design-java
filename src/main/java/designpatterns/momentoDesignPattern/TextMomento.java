package designpatterns.momentoDesignPattern;

import designpatterns.stateDesignPattern.state.State;

public class TextMomento {

    private String text;
    public TextMomento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
