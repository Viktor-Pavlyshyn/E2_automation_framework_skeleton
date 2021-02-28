package patterns.core.strategy;

import patterns.core.strategy.share.ShareBehavior;

public class CameraPlusApp extends PhoneCameraApp{

    public CameraPlusApp(ShareBehavior behavior) {
        shareBehavior = behavior;
    }

    @Override
    public void edit() {
        System.out.println("edit");
    }
}
