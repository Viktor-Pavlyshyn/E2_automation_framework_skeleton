package com.epam.webdriver.factoryimpltwo;

import com.epam.webdriver.factoryimpltwo.driverfactory.ChromeDriverManager;

public class Main {
    public static void main(String[] args) {
        DriverManager chromeFactory = new ChromeDriverManager();
        chromeFactory.getWebDriver();
    }
}
