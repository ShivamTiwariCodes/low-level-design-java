package designpatterns.adaptorDesignPattern.adaptee;

public class WeighingMachineForBabies implements WeighingMachine{

    private double weight = 100;

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeightInPound() {
        return weight;
    }
}
