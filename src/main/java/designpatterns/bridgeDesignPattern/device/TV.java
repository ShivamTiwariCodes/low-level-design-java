package designpatterns.bridgeDesignPattern.device;
public class TV implements Device{

    private boolean isPowerOn = false;
    private int volume = 50;

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("TV is turned on.");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("TV is turned off.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume < 0) volume = 0;
        this.volume = volume;
        System.out.println("TV volume is set to " + volume);
    }

    @Override
    public boolean isPoweredOn() {
        return isPowerOn;
    }

    @Override
    public int getVolume() {
        return volume;
    }
}
