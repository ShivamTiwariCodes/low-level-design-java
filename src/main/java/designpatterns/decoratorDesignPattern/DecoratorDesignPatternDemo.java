package designpatterns.decoratorDesignPattern;

import designpatterns.decoratorDesignPattern.base.PlainText;
import designpatterns.decoratorDesignPattern.base.TextComponent;
import designpatterns.decoratorDesignPattern.decorator.BoldTextDecorator;
import designpatterns.decoratorDesignPattern.decorator.ItalicTextDecorator;
import designpatterns.decoratorDesignPattern.decorator.UnderlineTextDecorator;

public class DecoratorDesignPatternDemo {

    public void run() {

        TextComponent plainText = new PlainText("This is text.");

        TextComponent boldText = new BoldTextDecorator(plainText);
        System.out.println("This is bold text : " + boldText.format());

        TextComponent boldItalicText = new ItalicTextDecorator(boldText);
        System.out.println("This is bold italic text : " + boldItalicText.format());

        TextComponent boldUnderLineText = new UnderlineTextDecorator(boldText);
        System.out.println("This is bold underline text : " + boldUnderLineText.format());

        TextComponent boldUnderLineItalictext = new UnderlineTextDecorator(boldItalicText);
        System.out.println("This is bold italic underline text : " + boldUnderLineItalictext.format());
    }
}
