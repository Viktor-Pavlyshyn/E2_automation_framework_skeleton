package patterns.main;

import patterns.core.strategy.BasicCameraApp;
import patterns.core.strategy.PhoneCameraApp;
import patterns.core.strategy.share.shareimpl.ShareEmail;
import patterns.core.strategy.share.shareimpl.ShareSocialMedia;
import patterns.core.strategy.share.shareimpl.ShareText;

public class StrategyTest {
    public static void main(String[] args) {
        PhoneCameraApp basicCameraSM = new BasicCameraApp(new ShareSocialMedia());

        basicCameraSM.take();
        basicCameraSM.edit();
        basicCameraSM.save();
        basicCameraSM.performShare();

        PhoneCameraApp BasicCameraE = new BasicCameraApp(new ShareEmail());

        BasicCameraE.take();
        BasicCameraE.edit();
        BasicCameraE.save();
        BasicCameraE.performShare();

        PhoneCameraApp BasicCameraT = new BasicCameraApp(new ShareText());

        BasicCameraT.take();
        BasicCameraT.edit();
        BasicCameraT.save();
        BasicCameraT.performShare();
    }
}
