package designpatterns.singletonDesignPattern;

public class Singleton {

    private static Singleton singleton;

    private Singleton() {}

    public static Singleton getSingleonInstance() {
        if(singleton == null) {
            System.out.println("Initializing sinleton instance...");
            singleton = new Singleton();
        }
        return singleton;
    }

    public void printMessage() {
        System.out.println("This message is from singleton object.");
    }

}
