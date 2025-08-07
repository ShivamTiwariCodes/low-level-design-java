package designpatterns.bridgeDesignPattern;

import designpatterns.bridgeDesignPattern.device.Device;
import designpatterns.bridgeDesignPattern.device.Radio;
import designpatterns.bridgeDesignPattern.device.TV;
import designpatterns.bridgeDesignPattern.remote.AdvanceRemote;
import designpatterns.bridgeDesignPattern.remote.BasicRemote;
import designpatterns.bridgeDesignPattern.remote.Remote;

public class BridgeDesignPatternDemo {

    public void run() {

        Device tv = new TV();
        Device radio = new Radio();

        Remote tvBasicRemote = new BasicRemote(tv);
        Remote tvAdvanceRemote = new AdvanceRemote(tv);

        Remote radioBasicRemote = new BasicRemote(radio);
        Remote radioAdvanceRemote = new AdvanceRemote(radio);

        tvBasicRemote.toogleOnOff();
        tvBasicRemote.increaseVolume();
        ((AdvanceRemote)tvAdvanceRemote).mute();
        tvAdvanceRemote.increaseVolume();

        radioBasicRemote.toogleOnOff();
        radioBasicRemote.increaseVolume();
        ((AdvanceRemote)radioAdvanceRemote).mute();
        radioAdvanceRemote.increaseVolume();
    }
}
