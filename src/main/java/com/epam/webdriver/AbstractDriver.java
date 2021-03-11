package com.epam.webdriver;

import org.openqa.selenium.WebDriver;

public abstract class AbstractDriver {

    protected abstract WebDriver createDriver();

    public WebDriver getCreatedDriver(){
        WebDriver driver = createDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
