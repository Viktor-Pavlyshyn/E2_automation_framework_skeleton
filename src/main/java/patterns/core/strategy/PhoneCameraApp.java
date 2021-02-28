package patterns.core.strategy;

import patterns.core.strategy.share.ShareBehavior;

public abstract class PhoneCameraApp {
    ShareBehavior shareBehavior;

    public void performShare(){
        shareBehavior.share();
    }

    public abstract void edit();

    public void take() {
        System.out.println("take");
    }

    public void save() {
        System.out.println("save");
    }
}
