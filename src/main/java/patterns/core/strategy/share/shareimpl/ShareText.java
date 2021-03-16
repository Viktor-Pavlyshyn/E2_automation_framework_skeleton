package patterns.core.strategy.share.shareimpl;

import patterns.core.strategy.share.ShareBehavior;

public class ShareText implements ShareBehavior {
    @Override
    public void share() {
        System.out.println("Share by text.");
    }
}
