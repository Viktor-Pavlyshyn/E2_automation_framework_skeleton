package patterns.core.adapter.droneimpl;

import patterns.core.adapter.Drone;

public class SuperDrone implements Drone {
    @Override
    public void beep() {
        System.out.println("Beep");
    }

    @Override
    public void spinRotors() {
        System.out.println("Rotors are spinning");
    }

    @Override
    public void takeOff() {
        System.out.println("Taking off");
    }
}
