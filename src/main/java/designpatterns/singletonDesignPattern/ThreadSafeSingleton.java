package designpatterns.singletonDesignPattern;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton threadSafeSingleton;

    private ThreadSafeSingleton() {}

    public static synchronized ThreadSafeSingleton getInstance() {
        if(threadSafeSingleton == null ) {
            System.out.println("Initialized thread safe singleton instance ...");
            threadSafeSingleton = new ThreadSafeSingleton();
        }
        return threadSafeSingleton;
    }

    public void printMessage() {
        System.out.println("This message is from thread safe singleton class.");
    }


}
