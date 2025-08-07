package designpatterns.abstractFactoryDesignPattern.factory;

import designpatterns.abstractFactoryDesignPattern.threeDShapes.Cube;
import designpatterns.abstractFactoryDesignPattern.threeDShapes.ThreeDShapes;
import designpatterns.factoryDesignPattern.shapes.Shape;
import designpatterns.factoryDesignPattern.shapes.Square;

public class LinearFactory implements DesignFactory{
    @Override
    public Shape create2D() {
        return new Square();
    }

    @Override
    public ThreeDShapes create3D() {
        return new Cube();
    }
}
