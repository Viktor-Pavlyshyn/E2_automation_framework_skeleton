package selenide.actions;

import io.qameta.allure.Step;
import selenide.page.object.RefHelpPage;

public class RefHelpActions extends BaseActions {
    private final RefHelpPage refHelpPage = new RefHelpPage();

    @Step("Get text form title Help Contents")
    public String getTextHelpContents(){
        return refHelpPage.getTextHelpContents();
    }
}
