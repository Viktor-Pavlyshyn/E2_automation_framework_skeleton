package patterns.main;

import patterns.core.state.Context;
import patterns.core.state.stateimple.LockedState;

public class StateTest {
    public static void main(String[] args) {
        Context context = new Context(new LockedState());

        context.pushRequest();

        context.coinRequest();
        context.coinRequest();

        context.pushRequest();
        context.pushRequest();
    }
}
