package designpatterns.bridgeDesignPattern.device;
public class Radio implements Device{

    private boolean isPowerOn = false;
    private int volume = 50;

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("Radio is turned on.");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("Radio is turned off.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume < 0) volume = 0;
        this.volume = volume;
        System.out.println("Radio volume is set to " + volume);
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
