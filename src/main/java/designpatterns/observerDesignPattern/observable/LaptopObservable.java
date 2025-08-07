package designpatterns.observerDesignPattern.observable;

import designpatterns.observerDesignPattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class LaptopObservable implements NotificationObservable{

    private List<Observer> observerList;
    private int stock = 0;

    public LaptopObservable() {
        observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observerList) {
            observer.updateObservers();
        }
    }

    @Override
    public void addStock(int count) {
        if(stock == 0) {
            notifyObservers();
        }
        stock += count;
    }
}
