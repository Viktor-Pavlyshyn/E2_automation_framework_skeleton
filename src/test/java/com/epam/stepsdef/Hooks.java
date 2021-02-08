package com.epam.stepsdef;

import io.cucumber.java.After;

import static com.epam.webdriver.LocalDriverManager.closeDriver;

public class Hooks {

    @After
    public void closeSite() {
        closeDriver();
    }
}
