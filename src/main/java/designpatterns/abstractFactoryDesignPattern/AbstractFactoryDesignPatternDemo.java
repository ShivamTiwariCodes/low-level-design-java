package designpatterns.abstractFactoryDesignPattern;

import designpatterns.abstractFactoryDesignPattern.factory.CircularFactory;
import designpatterns.abstractFactoryDesignPattern.factory.LinearFactory;
import designpatterns.abstractFactoryDesignPattern.threeDShapes.ThreeDShapes;
import designpatterns.factoryDesignPattern.shapes.Shape;

public class AbstractFactoryDesignPatternDemo {


    public void run() {
        CircularFactory circularFactory = new CircularFactory();

        Shape circle = circularFactory.create2D();
        circle.draw();

        ThreeDShapes sphere = circularFactory.create3D();
        sphere.build();

        LinearFactory linearFactory = new LinearFactory();

        Shape square = linearFactory.create2D();
        square.draw();

        ThreeDShapes cube = linearFactory.create3D();
        cube.build();
    }

}
