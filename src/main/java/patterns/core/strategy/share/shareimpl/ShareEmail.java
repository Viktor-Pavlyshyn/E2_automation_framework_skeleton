package patterns.core.strategy.share.shareimpl;

import patterns.core.strategy.share.ShareBehavior;

public class ShareEmail implements ShareBehavior {
    @Override
    public void share() {
        System.out.println("Share by email.");
    }
}
