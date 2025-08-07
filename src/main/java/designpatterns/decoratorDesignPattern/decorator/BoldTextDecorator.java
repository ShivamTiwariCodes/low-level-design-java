package designpatterns.decoratorDesignPattern.decorator;

import designpatterns.decoratorDesignPattern.base.TextComponent;

public class BoldTextDecorator extends TextDecorator{

    private TextComponent textComponent;

    public BoldTextDecorator(TextComponent textComponent) {
        this.textComponent = textComponent;
    }

    public String format() {
        return "<b>" + textComponent.format() + "</b>";
    }
}
