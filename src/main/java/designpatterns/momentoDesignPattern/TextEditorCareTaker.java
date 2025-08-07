package designpatterns.momentoDesignPattern;

import designpatterns.stateDesignPattern.state.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TextEditorCareTaker {

    Stack<TextMomento> textMomentoList = new Stack<>();

    public void save(TextMomento textMomento) {
        textMomentoList.push(textMomento);
    }

    public TextMomento undo() {
        if(!textMomentoList.isEmpty()) return textMomentoList.pop();
        return null;
    }


}
