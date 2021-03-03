package patterns.core.state.stateimple;

import patterns.core.state.Context;
import patterns.core.state.State;

public class LockedState implements State {
    @Override
    public void coin(Context context) {
        System.out.println("Unlocked.");
        context.setState(new UnlockedState());
    }

    @Override
    public void push(Context context) {
        System.out.println("Locked.");
    }
}
