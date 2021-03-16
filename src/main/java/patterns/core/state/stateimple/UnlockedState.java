package patterns.core.state.stateimple;

import patterns.core.state.Context;
import patterns.core.state.State;

public class UnlockedState implements State {
    @Override
    public void coin(Context context) {
        System.out.println("Already unlocked.");
    }

    @Override
    public void push(Context context) {
        System.out.println("+1 visitor.");
        context.setState(new LockedState());
    }
}
