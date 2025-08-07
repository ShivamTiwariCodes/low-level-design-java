package designpatterns.iteratorDesignPattern.iterator;

import designpatterns.facadeDesignPattern.Projector;
import designpatterns.iteratorDesignPattern.Profile;

public interface Iterator {
    boolean hasNext();
    Profile next();
}
