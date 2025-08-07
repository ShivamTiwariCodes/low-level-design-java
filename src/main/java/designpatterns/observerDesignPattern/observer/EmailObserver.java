package designpatterns.observerDesignPattern.observer;

import designpatterns.observerDesignPattern.observable.NotificationObservable;

public class EmailObserver implements Observer{

    private String email;
    private NotificationObservable notificationObservable;

    public EmailObserver(String email, NotificationObservable notificationObservable) {
        this.email = email;
        this.notificationObservable = notificationObservable;
    }

    @Override
    public void updateObservers() {
        sendEmail();
    }

    void sendEmail() {
        System.out.println("Email is sent to : " + email);
    }
}
