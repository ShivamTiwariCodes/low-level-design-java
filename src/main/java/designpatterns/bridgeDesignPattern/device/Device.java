package designpatterns.bridgeDesignPattern.device;

public interface Device {

    void powerOn();
    void powerOff();
    void setVolume(int volume);
    boolean isPoweredOn();
    int getVolume();
}
