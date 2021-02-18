package com.epam.webdriver.drivers.impl;

import com.epam.webdriver.drivers.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements Driver {

    @Override
    public WebDriver setUpDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}