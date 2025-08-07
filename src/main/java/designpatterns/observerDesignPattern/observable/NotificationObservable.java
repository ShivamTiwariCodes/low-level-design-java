package designpatterns.observerDesignPattern.observable;

import designpatterns.observerDesignPattern.observer.Observer;

import java.util.List;

public interface NotificationObservable {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    void addStock(int count);


}
