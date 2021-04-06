package selenide.actions;

import io.qameta.allure.Step;
import selenide.page.object.WikipediaPage;

public class BaseActions {
    private final WikipediaPage wikipediaPage = new WikipediaPage();

    @Step("user uses search with value - {inputValue}")
    public void inputSearchValueAndClickSearchButton(String inputValue) {
        wikipediaPage.inputSearchValue(inputValue);
        wikipediaPage.clickSearchButton();
    }

    @Step("User navigates to the Community Portal page")
    public void clickOnRefCommunityPortal() {
        wikipediaPage.clickOnRefCommunityPortal();
    }

    @Step("User navigates to the About Help page")
    public void clickOnRefHelp() {
        wikipediaPage.clickOnRefHelp();
    }

    @Step("User navigates to the About Wikipedia page")
    public void clickOnRefAboutWikipedia() {
        wikipediaPage.clickOnRefAboutWikipedia();
    }

    @Step("User navigates to the About Talk Main page")
    public void clickOnRefTalk() {
        wikipediaPage.clickOnRefTalk();
    }
}
