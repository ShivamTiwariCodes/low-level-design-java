package designpatterns.prototypeDesignPattern;

public class PrototypeDesignPatternDemo {


    public void run() {

        Prototype mainObject = new Student(1, "Student 1", "8323827382", "Address 1");
        Prototype prototypeObject = mainObject.clone();

        System.out.println("Main object : " + mainObject.toString());
        System.out.println("Prototype object : " + prototypeObject.toString());
    }


}
