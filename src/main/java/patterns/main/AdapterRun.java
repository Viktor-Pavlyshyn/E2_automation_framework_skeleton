package patterns.main;

import patterns.core.adapter.DroneAdapter;
import patterns.core.adapter.Duck;
import patterns.core.adapter.droneimpl.SuperDrone;
import patterns.core.adapter.duckimpl.MallardDuck;

public class AdapterRun {
    public static void main(String[] args) {
        testDuck(new MallardDuck());

        testDuck(new DroneAdapter(new SuperDrone()));
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
