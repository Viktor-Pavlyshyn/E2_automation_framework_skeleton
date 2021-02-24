package com.epam.webdriver.factory.impl;

import com.epam.webdriver.drivers.Driver;
import com.epam.webdriver.drivers.impl.Chrome;
import com.epam.webdriver.drivers.impl.Firefox;
import com.epam.webdriver.factory.AbstractDriver;

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class BrowserDriver extends AbstractDriver {

    @Override
    protected Driver createDriver(String browser) {
        Driver driver = null;

        if (equalsIgnoreCase(browser, CHROME)) {
            driver = new Chrome();
        } else if (equalsIgnoreCase(browser, FIREFOX)) {
            driver = new Firefox();
        }
        return driver;
    }
}
