package designpatterns.factoryDesignPattern;

import designpatterns.factoryDesignPattern.shapes.Circle;
import designpatterns.factoryDesignPattern.shapes.Shape;
import designpatterns.factoryDesignPattern.shapes.Square;
import designpatterns.factoryDesignPattern.shapes.Rectangle;

public class ShapeFactory {

    public Shape getShape(String shape) {

        switch (shape) {
            case "circle":
                return new Circle();
            case "square":
                return new Square();
            case "rectangle":
                return new Rectangle();
            default:
                System.out.println("Please provide the correct shape name. Given name : " + shape);
                return null;
        }
    }
}
