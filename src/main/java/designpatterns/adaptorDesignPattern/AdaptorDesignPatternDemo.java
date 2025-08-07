package designpatterns.adaptorDesignPattern;

import designpatterns.adaptorDesignPattern.adaptee.WeighingMachine;
import designpatterns.adaptorDesignPattern.adaptee.WeighingMachineForBabies;
import designpatterns.adaptorDesignPattern.adaptor.WeighingMachineAdaptor;
import designpatterns.adaptorDesignPattern.adaptor.WeighingMachineAdaptorToKg;

public class AdaptorDesignPatternDemo {

    public void run() {
        WeighingMachine weighingMachine = new WeighingMachineForBabies();
        WeighingMachineAdaptor weighingMachineAdaptor = new WeighingMachineAdaptorToKg(weighingMachine);

        System.out.println("Weight in pound : " + weighingMachine.getWeightInPound());
        System.out.println("Weight in kg : " + weighingMachineAdaptor.getWeightInKg());
    }
}
