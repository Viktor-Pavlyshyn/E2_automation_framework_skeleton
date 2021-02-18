package com.epam.webdriver.drivers.impl;

import com.epam.webdriver.drivers.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements Driver {

    @Override
    public WebDriver setUpDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
