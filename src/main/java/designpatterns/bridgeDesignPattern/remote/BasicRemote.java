package designpatterns.bridgeDesignPattern.remote;

import designpatterns.bridgeDesignPattern.device.Device;

public class BasicRemote extends Remote{

    public BasicRemote(Device device) {
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
}
