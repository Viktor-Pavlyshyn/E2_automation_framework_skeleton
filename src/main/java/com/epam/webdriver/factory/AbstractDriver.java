package com.epam.webdriver.factory;

import com.epam.webdriver.drivers.Driver;
import org.openqa.selenium.WebDriver;

public abstract class AbstractDriver {

    protected abstract Driver createDriver(String browser);

    public WebDriver getCreatedDriver(String browser){
        Driver driver = createDriver(browser);
        return driver.setUpDriver();
    }
}
