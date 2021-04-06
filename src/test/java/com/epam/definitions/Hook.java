package com.epam.definitions;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.epam.webdriver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;

import java.io.*;

public class Hook {
    protected WebDriver driver;
    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests().succeededTests();

    @Before
    public void setUp() {
        driver = DriverManager.getWebDriver();
        configurationSelenide();
        WebDriverRunner.setWebDriver(driver);
    }

    private void configurationSelenide() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.timeout = 6000;
        Configuration.pollingInterval = 200;
    }

    @After
    public void tearDown(){
        screenshot();
        driver.quit();
    }

    public void screenshot(){
        File screenshot = Screenshots.takeScreenShotAsFile();
        InputStream targetStream = null;
        try {
            targetStream = new FileInputStream(screenshot);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Allure.addAttachment("Screenshot on fail", "image/png", targetStream, "png");
    }
}
