package selenide.actions;

import io.qameta.allure.Step;
import selenide.page.object.SearchAppleResultPage;

public class SearchAppleResultActions extends BaseActions {
    private final SearchAppleResultPage searchAppleResultPage = new SearchAppleResultPage();

    @Step("Get size 'Contents' items from Result Apple Page")
    public int getSizeOfContents(){
        return searchAppleResultPage.getSizeOfContents();
    }
}
