package com.epam.definitions;

import io.cucumber.java.After;

import static com.epam.webdriver.DriverManager.closeDriver;

public class Hooks {

    @After
    public void closeSite() {
        closeDriver();
    }
}
