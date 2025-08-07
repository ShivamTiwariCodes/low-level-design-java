package designpatterns.singletonDesignPattern;

public class SingletonDesignPatternDemo {


    public void run() {

        Singleton singleton = Singleton.getSingleonInstance();
        Singleton.getSingleonInstance();
        singleton.printMessage();

        ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton.getInstance();
        threadSafeSingleton.printMessage();

        DoubleCheckedLockedSingleton  doubleCheckedLockedSingleton = DoubleCheckedLockedSingleton.getInstance();
        DoubleCheckedLockedSingleton.getInstance();
        doubleCheckedLockedSingleton.printMessage();
    }

}
