package patterns.core.strategy;

import patterns.core.strategy.share.ShareBehavior;

public class BasicCameraApp extends PhoneCameraApp{

    public BasicCameraApp(ShareBehavior behavior) {
        shareBehavior = behavior;
    }

    @Override
    public void edit() {
        System.out.println("edit");
    }
}
