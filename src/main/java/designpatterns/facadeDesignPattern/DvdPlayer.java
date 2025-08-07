package designpatterns.facadeDesignPattern;

public class DvdPlayer {

    public void turnOff() {
        System.out.println("DvdPlayer is turned off");
    }

    public void turnOn() {
        System.out.println("DvdPlayer is turned on");
    }

    public void playMovie(String movie) {
        System.out.println("Starting movie : " + movie);
    }
}
