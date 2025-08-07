package designpatterns.facadeDesignPattern;

public class Amplifier {

    public void turnOff() {
        System.out.println("Amplifier is turned off");
    }

    public void turnOn() {
        System.out.println("Amplifier is turned on");
    }

    public void setVolume(int volume) {
        System.out.println("Amplifier volume is set to : " + volume);
    }
}
