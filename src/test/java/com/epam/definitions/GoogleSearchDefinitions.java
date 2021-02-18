package com.epam.definitions;

import com.epam.businessobject.GoogleSearchBO;
import com.epam.businessobject.ResultSearchGoogleBO;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.epam.webdriver.DriverManager.closeDriver;
import static com.epam.webdriver.DriverManager.getWebDriver;
import static org.junit.Assert.assertTrue;

public class GoogleSearchDefinitions {

    @Given("open {string}")
    public void openPage(String url) {
        getWebDriver().get(url);
    }

    @When("enter {string} and search")
    public void search(String inputValue) {

        //TODO Create repository to verify and get instance of actions from here
        //TODO I prefer to name it like SomeFeatureActions
        new GoogleSearchBO().inputAndSearch(inputValue);

    }

    @Then("verify link on position {int} contains text {string}")
    public void verifyTitle(int position, String text) {

        final String response = new ResultSearchGoogleBO()
                .getLinkTextByPosition(position);

        assertTrue(String.format("Text does not contains - '%s'.", text), response.matches("([\\s\\S]*)" + text + "([\\s\\S]*)"));
    }

    @After
    public void closeSite() {
        closeDriver();
    }
}
