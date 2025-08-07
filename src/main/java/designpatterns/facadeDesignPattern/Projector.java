package designpatterns.facadeDesignPattern;

public class Projector {

    public void turnOff() {
        System.out.println("Projector is turned off");
    }

    public void turnOn() {
        System.out.println("Projector is turned on");
    }

    public void setInput(String input) {
        System.out.println("Input is set to : " + input);
    }
}
