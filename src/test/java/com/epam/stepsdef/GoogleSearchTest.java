package com.epam.stepsdef;

import com.epam.businessobject.GoogleSearchBO;
import com.epam.businessobject.ResultSearchGoogleBO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.epam.webdriver.LocalDriverManager.getWebDriver;
import static org.junit.Assert.*;

public class GoogleSearchTest {

    @Given("^open \"(.*)\"$")
    public void openPage(String url) {
        getWebDriver().get(url);
    }

    @Then("^enter \"(.*)\" and search$")
    public void search(String inputValue) {

        new GoogleSearchBO().inputAndSearch(inputValue);

    }

    @Then("^verify if wikipedia title contains text \"(.*)\"$")
    public void verifyTitle(String text) {

        String response = new ResultSearchGoogleBO().getTitleValue();

        assertTrue(String.format("Title does not contains - '%s'.", text), new ResultSearchGoogleBO().getTitleValue().toLowerCase().contains(text));
    }
}
