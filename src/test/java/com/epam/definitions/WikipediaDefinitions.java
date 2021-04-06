package com.epam.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenide.actions.ActionsRepository;

import static com.codeborne.selenide.Selenide.open;
import static com.epam.utils.DataPropLoader.getBrowserProperty;
import static org.junit.Assert.*;


public class WikipediaDefinitions {
    protected ActionsRepository actions = new ActionsRepository();

    @Given("open page Wikipedia")
    public void openPageWikipedia(){
        open(getBrowserProperty("base.url"));
    }

    @When("user navigates to the About Wikipedia page")
    public void userNavigatesToAboutWikipedia(){
        actions.getBaseActions().clickOnRefAboutWikipedia();
    }

    @When ("user navigates to the Community Portal page")
    public void userNavigatesToCommunityPortal(){
        actions.getBaseActions().clickOnRefCommunityPortal();
    }

    @When ("user navigates to the About Help page")
    public void userNavigatesToAboutHelpPage(){
        actions.getBaseActions().clickOnRefHelp();
    }

    @When ("user navigates to the About Talk Main page")
    public void userNavigatesToAboutTalkMain(){
        actions.getBaseActions().clickOnRefTalk();
    }

    @Then ("verify About Wikipedia page has title {string}")
    public void verifyTitleAboutWikipedia(String input){
        final String text = actions.getRefAboutWikipediaActions().getTextWikipediaAbout();
        assertTrue(text.contains(input));
    }

    @Then ("verify Community Portal page has title {string}")
    public void verifyTitleCommunityPortal(String input){
        final String text = actions.getRefCommunityPortalActions().getTextWikipediaCommunityPortal();
        assertTrue(text.contains(input));
    }

    @Then ("verify About Help Page Portal page has title {string}")
    public void verifyTitleAboutHelpPage(String input){
        final String text = actions.getRefHelpActions().getTextHelpContents();
        assertTrue(text.contains(input));
    }

    @Then ("verify About Talk Main page has title {string}")
    public void verifyTitleAboutTalkMain(String input){
        final String text = actions.getRefTalkActions().getTextTalkMain();
        assertTrue(text.contains(input));
    }

    @When("user uses search with value - {string}")
    public void userUsesSearchWithValue(String inputValue){
        actions.getBaseActions().inputSearchValueAndClickSearchButton(inputValue);
    }

    @Then ("verify size 'Contents' item in Search Result page when user searches 'apple'")
    public void verifySizeItemInSearchResult(){
        final int size = actions.getSearchAppleResultActions().getSizeOfContents();
        assertEquals(30, size);
    }
}
