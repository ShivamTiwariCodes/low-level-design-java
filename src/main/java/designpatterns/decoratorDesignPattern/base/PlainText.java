package designpatterns.decoratorDesignPattern.base;

public class PlainText implements TextComponent {

    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public String format() {
        return text;
    }
}
