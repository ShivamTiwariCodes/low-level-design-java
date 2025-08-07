package designpatterns.abstractFactoryDesignPattern.factory;

import designpatterns.abstractFactoryDesignPattern.threeDShapes.Sphere;
import designpatterns.abstractFactoryDesignPattern.threeDShapes.ThreeDShapes;
import designpatterns.factoryDesignPattern.shapes.Circle;
import designpatterns.factoryDesignPattern.shapes.Shape;

public class CircularFactory implements DesignFactory{
    @Override
    public Shape create2D() {
        return new Circle();
    }

    @Override
    public ThreeDShapes create3D() {
        return new Sphere();
    }
}
