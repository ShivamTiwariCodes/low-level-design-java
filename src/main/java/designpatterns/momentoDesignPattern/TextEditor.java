package designpatterns.momentoDesignPattern;

// originator class to take the action
public class TextEditor {

    StringBuilder textBuilder = new StringBuilder();

    public void append(String text) {
        textBuilder.append(text);
    }

    public String getText() {
        return textBuilder.toString();
    }

    public TextMomento saveToMomento() {
        return new TextMomento(textBuilder.toString());
    }

    public void restore(TextMomento textMomento) {
        if(textMomento == null) return;
        textBuilder = new StringBuilder(textMomento.getText());
    }

}
