package designpatterns.abstractFactoryDesignPattern.factory;

import designpatterns.abstractFactoryDesignPattern.threeDShapes.ThreeDShapes;
import designpatterns.factoryDesignPattern.shapes.Shape;

public interface DesignFactory {
    Shape create2D();
    ThreeDShapes create3D();
}
