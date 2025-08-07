package designpatterns.singletonDesignPattern;

public class DoubleCheckedLockedSingleton {

    private static DoubleCheckedLockedSingleton doubleCheckedLockedSingleton;

    private DoubleCheckedLockedSingleton(){}

    public static DoubleCheckedLockedSingleton getInstance() {

        if(doubleCheckedLockedSingleton == null) {
            synchronized (DoubleCheckedLockedSingleton.class) {
                if(doubleCheckedLockedSingleton == null) {
                    System.out.println("Initialized double checked locked singleton ...");
                    doubleCheckedLockedSingleton = new DoubleCheckedLockedSingleton();
                }
            }
        }
        return doubleCheckedLockedSingleton;
    }

    public void printMessage() {
        System.out.println("This message is from double checked loacked singleton.");
    }
}
