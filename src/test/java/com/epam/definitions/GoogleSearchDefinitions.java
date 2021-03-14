package com.epam.definitions;

import com.epam.businessobject.ActionsProvider;
import com.epam.utils.data.SearchBuilder;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.epam.webdriver.DriverManager.closeDriver;
import static com.epam.webdriver.DriverManager.getWebDriver;
import static org.junit.Assert.assertTrue;

public class GoogleSearchDefinitions {
    protected ActionsProvider actionsProvider = new ActionsProvider();

    @Given("open {string}")
    public void openPage(String url) {
        getWebDriver().get(url);
    }

    @When("enter {string} and search")
    public void search(String inputValue) {
        String searchData = new SearchBuilder()
                .addApple(inputValue)
                .buildSearch();

        //TODO Create repository to verify and get instance of actions from here
        //TODO I prefer to name it like SomeFeatureActions
        actionsProvider.getGoogleSearchBO()
                .inputAndSearch(searchData);

    }

    @Then("verify link on position {int} contains text {string}")
    public void verifyTitle(int position, String text) {

        final String response = actionsProvider.getResultSearchGoogleBO()
                .getLinkTextByPosition(position);

        assertTrue(String.format("Text does not contains - '%s'.", text), response.matches("([\\s\\S]*)" + text + "([\\s\\S]*)"));
    }

    @After
    public void closeSite() {
        closeDriver();
    }
}
