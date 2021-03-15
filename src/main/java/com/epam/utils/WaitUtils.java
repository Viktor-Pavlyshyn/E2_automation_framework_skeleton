package com.epam.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class WaitUtils {
    private static DataPropLoader dataProp = DataPropLoader.getDataPropLoader();

    public static Wait<WebDriver> fWait(WebDriver driver) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Long.parseLong(dataProp.getProperty("wait.timeout"))))
                .pollingEvery(Duration.ofSeconds(Long.parseLong(dataProp.getProperty("wait.polling.every.time"))))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }
}