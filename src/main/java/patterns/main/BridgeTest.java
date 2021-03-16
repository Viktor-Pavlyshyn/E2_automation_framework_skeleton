package patterns.main;

import patterns.core.bridge.*;
import patterns.core.bridge.device.AdvancedRemote;
import patterns.core.bridge.BasicRemote;
import patterns.core.bridge.device.Radio;
import patterns.core.bridge.device.Tv;

public class BridgeTest {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
