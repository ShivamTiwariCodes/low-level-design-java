package designpatterns.bridgeDesignPattern.remote;

import designpatterns.bridgeDesignPattern.device.Device;

public abstract class Remote {

    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public abstract void toogleOnOff();
    public abstract void increaseVolume();
    public abstract void decreaseVolume();
}
