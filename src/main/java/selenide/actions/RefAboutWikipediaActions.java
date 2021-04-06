package selenide.actions;

import io.qameta.allure.Step;
import selenide.page.object.RefAboutWikipediaPage;

public class RefAboutWikipediaActions extends BaseActions {
    private final RefAboutWikipediaPage refAboutWikipediaPage = new RefAboutWikipediaPage();

    @Step("Get text form title Wikipedia About")
    public String getTextWikipediaAbout() {
        return refAboutWikipediaPage.getTextWikipediaAbout();
    }
}
