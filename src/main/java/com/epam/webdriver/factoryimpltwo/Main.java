package com.epam.webdriver.factoryimpltwo;

import com.epam.webdriver.factoryimpltwo.driverfactory.ChromeDriverFactory;
import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        WebDriverFactory chromeFactory = new ChromeDriverFactory();
        WebDriver driver = chromeFactory.createDriver();
    }
}
