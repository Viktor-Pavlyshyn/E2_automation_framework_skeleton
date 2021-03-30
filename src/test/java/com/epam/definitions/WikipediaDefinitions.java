package com.epam.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenide.actions.ActionsRepository;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;


public class WikipediaDefinitions {
    protected ActionsRepository actions = new ActionsRepository();

    @Given("open browser on url")
    public void openBrowserOnUrl(){
        open("https://en.wikipedia.org/");
    }

    @When("user clicks on About Wikipedia")
    public void userClicksOnAboutWikipedia(){
        actions.getWikipediaActions().clickOnRefAboutWikipedia();
    }

    @When ("user clicks on Community Portal")
    public void userClicksOnCommunityPortal(){
        actions.getWikipediaActions().clickOnRefCommunityPortal();
    }

    @When ("user clicks on About Help Page")
    public void userClicksOnAboutHelpPage(){
        actions.getWikipediaActions().clickOnRefHelp();
    }

    @When ("user clicks on About Talk Main")
    public void userClicksOnAboutTalkMain(){
        actions.getWikipediaActions().clickOnRefTalk();
    }

    @Then ("verify title About Wikipedia")
    public void verifyTitleAboutWikipedia(){
        final String text = actions.getRefAboutWikipediaActions().getTextWikipediaAbout();
        assertTrue(text.contains("About"));
    }

    @Then ("verify title Community Portal")
    public void verifyTitleCommunityPortal(){
        final String text = actions.getRefCommunityPortalActions().getTextWikipediaCommunityPortal();
        assertTrue(text.contains("Community"));
    }

    @Then ("verify title About Help Page")
    public void verifyTitleAboutHelpPage(){
        final String text = actions.getRefHelpActions().getTextHelpContents();
        assertTrue(text.contains("Help"));
    }

    @Then ("verify title About Talk Main")
    public void verifyTitleAboutTalkMain(){
        final String text = actions.getRefTalkActions().getTextTalkMain();
        assertTrue(text.contains("Talk"));
    }

    @When("user enters search value - {string} and clicks on search button")
    public void enterSearchValueAndClicksOnSearchButton(String inputValue){
        actions.getWikipediaActions().inputSearchValueAndClickSearchButton(inputValue);
    }

    @Then ("verify Contents of Search Result")
    public void verifyTitleSearchResult(){
        final int size = actions.getSearchResultActions().getSizeOfContents();
        assertEquals(2, size);
    }
}
