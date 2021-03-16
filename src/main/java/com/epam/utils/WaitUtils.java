package com.epam.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static com.epam.utils.DataPropLoader.getBrowserProperty;
import static com.epam.webdriver.DriverManager.getWebDriver;

public class WaitUtils {

    public static WebElement fWaitUtil(ExpectedCondition<WebElement> condition) {
        return new FluentWait<>(getWebDriver())
                .withTimeout(Duration.ofSeconds(Long.parseLong(getBrowserProperty("wait.timeout"))))
                .pollingEvery(Duration.ofSeconds(Long.parseLong(getBrowserProperty("wait.polling.every.time"))))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class).until(condition);
    }
}