package designpatterns.observerDesignPattern;

import designpatterns.observerDesignPattern.observable.LaptopObservable;
import designpatterns.observerDesignPattern.observable.NotificationObservable;
import designpatterns.observerDesignPattern.observer.EmailObserver;
import designpatterns.observerDesignPattern.observer.Observer;
import designpatterns.observerDesignPattern.observer.PhoneObserver;

public class ObserverDesignPatternDemo {

    public void run() {
        NotificationObservable notificationObservable = new LaptopObservable();

        Observer phoneObserver1 = new PhoneObserver("7878787878", notificationObservable);
        Observer phoneObserver2 = new PhoneObserver("7878787877", notificationObservable);
        Observer emailObserver1 = new EmailObserver("test1@gmail.com", notificationObservable);
        Observer emailObserver2 = new EmailObserver("test2@gmail.com", notificationObservable);

        notificationObservable.addObserver(phoneObserver1);
        notificationObservable.addObserver(phoneObserver2);
        notificationObservable.addObserver(emailObserver1);
        notificationObservable.addObserver(emailObserver2);

        notificationObservable.addStock(10);
    }

}
