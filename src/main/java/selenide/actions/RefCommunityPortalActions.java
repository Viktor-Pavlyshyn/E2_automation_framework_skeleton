package selenide.actions;

import io.qameta.allure.Step;
import selenide.page.object.RefCommunityPortalPage;

public class RefCommunityPortalActions extends BaseActions {
    private final RefCommunityPortalPage refCommunityPortalPage = new RefCommunityPortalPage();

    @Step("Get text form title Wikipedia Community Portal")
    public String getTextWikipediaCommunityPortal() {
        return refCommunityPortalPage.getTextWikipediaCommunityPortal();
    }
}
