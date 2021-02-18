package com.epam.stepsdef;

import com.epam.businessobject.GoogleSearchBO;
import com.epam.businessobject.ResultSearchGoogleBO;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.epam.webdriver.LocalDriverManager.closeDriver;
import static com.epam.webdriver.LocalDriverManager.getWebDriver;
import static org.junit.Assert.assertTrue;

public class GoogleSearchTest {

    /*
     *TODO
     * 1. Cucumber alternative pattern style
     *
     **/

    @Given("^open \"(.*)\"$")
    public void openPage(String url) {
        getWebDriver().get(url);
    }

    //TODO it is When. Then is about verifications
    @Then("^enter \"(.*)\" and search$")
    public void search(String inputValue) {

        //TODO Create repository to verify and get instance of actions from here
        //TODO I prefer to name it like SomeFeatureActions
        new GoogleSearchBO().inputAndSearch(inputValue);

    }

    @Then("^verify if wikipedia title contains text \"(.*)\"$")
    public void verifyTitle(String text) {

        //TODO always use final if you sure you will not rewrite it
        //TODO unused variable 'response'
        String response = new ResultSearchGoogleBO().getTitleValue();

        //TODO Try to use Matcher library to assert
        //TODO it is better to avoid explicit modification. There is StringUtils which can compare without case sensitivity
//        StringUtils.equalsIgnoreCase()
        assertTrue(String.format("Title does not contains - '%s'.", text), new ResultSearchGoogleBO().getTitleValue().toLowerCase().contains(text));
    }

    @After
    public void closeSite() {
        closeDriver();
    }
}
