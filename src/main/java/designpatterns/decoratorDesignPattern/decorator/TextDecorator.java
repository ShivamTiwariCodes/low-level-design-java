package designpatterns.decoratorDesignPattern.decorator;

import designpatterns.decoratorDesignPattern.base.TextComponent;

public abstract class TextDecorator implements TextComponent {
    @Override
    abstract public String format();
}
