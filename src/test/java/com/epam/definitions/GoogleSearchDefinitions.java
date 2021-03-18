package com.epam.definitions;

import com.epam.actions.ActionsRepository;
import com.epam.utils.data.SearchBuilder;
import com.epam.utils.data.SearchData;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.epam.slackintegration.SlackIntegration.postToSlack;
import static com.epam.webdriver.DriverManager.closeDriver;
import static com.epam.webdriver.DriverManager.getWebDriver;
import static org.junit.Assert.assertTrue;

public class GoogleSearchDefinitions {
    protected ActionsRepository actionsRepository = new ActionsRepository();

    @Given("open {string}")
    public void openPage(String url) {
        getWebDriver().get(url);
    }

    @When("enter {string} and search")
    public void search(String inputValue) {
        SearchData searchData = new SearchBuilder()
                .query(inputValue)
                .buildSearch();

        actionsRepository.getSearchActions()
                .inputAndSearch(searchData);

    }

    @Then("verify text Title Wikipedia contains - {string}")
    public void verifyTitle(String text) {

        final String textWiki = actionsRepository.getResultSearchActions()
                .getTextTitleWikipedia();

        if(textWiki.matches("([\\s\\S]*)")){
            postToSlack(textWiki);
        } else {
        postToSlack("expected - " + text + ", but found - " + textWiki);
    }

        assertTrue(String.format("Text does not contains - '%s'.", text), textWiki.matches("([\\s\\S]*)" + text + "([\\s\\S]*)"));
    }

    @After
    public void closeSite() {
        closeDriver();
    }
}
