package com.epam.definitions;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Rule;
import org.openqa.selenium.remote.RemoteWebDriver;
import sauce.labs.SauceLabs;

public class Hook {
    protected RemoteWebDriver driver;

    @Rule
    public ScreenShooter makeScreenshotOnEveryTest =
            ScreenShooter.failedTests().succeededTests();

    @Before
    public void setUp() {
        driver = new SauceLabs().createSauceLabs();
        configurationSelenide();
        WebDriverRunner.setWebDriver(driver);
    }

    private void configurationSelenide() {
        Configuration.timeout = 6000;
        Configuration.pollingInterval = 200;
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.reportsFolder = "test-result/reports";
       SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
