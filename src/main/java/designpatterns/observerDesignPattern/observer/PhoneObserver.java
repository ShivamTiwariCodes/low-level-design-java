package designpatterns.observerDesignPattern.observer;

import designpatterns.observerDesignPattern.observable.NotificationObservable;

public class PhoneObserver implements Observer{

    private String phone;
    private NotificationObservable notificationObservable;

    public PhoneObserver(String phone, NotificationObservable notificationObservable) {
        this.phone = phone;
        this.notificationObservable = notificationObservable;
    }


    @Override
    public void updateObservers() {
        sendMessage();
    }

    private void sendMessage() {
        System.out.println("Message sent to phone : " + phone);
    }
}
