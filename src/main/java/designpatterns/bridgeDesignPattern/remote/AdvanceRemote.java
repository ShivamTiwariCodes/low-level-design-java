package designpatterns.bridgeDesignPattern.remote;

import designpatterns.bridgeDesignPattern.device.Device;

public class AdvanceRemote extends Remote{
    public AdvanceRemote(Device device) {
        super(device);
    }

    @Override
    public void toogleOnOff() {
        if(this.device.isPoweredOn()) {
            this.device.powerOff();
        } else {
            this.device.powerOn();
        }
    }

    @Override
    public void increaseVolume() {
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void decreaseVolume() {
        device.setVolume(device.getVolume() - 10);
    }

    public void mute() {
        device.setVolume(0);
        System.out.println("Device is muted.");
    }
}
