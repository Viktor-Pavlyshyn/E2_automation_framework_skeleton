package selenide.actions;

import io.qameta.allure.Step;
import selenide.page.object.RefTalkPage;

public class RefTalkActions extends BaseActions {
    private final RefTalkPage refTalkPage = new RefTalkPage();

    @Step("Get text form title Talk")
    public String getTextTalkMain(){
        return refTalkPage.getTextTalkMain();
    }
}
