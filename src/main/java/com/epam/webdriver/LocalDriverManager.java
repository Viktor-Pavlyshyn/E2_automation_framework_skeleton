package com.epam.webdriver;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

import static com.epam.webdriver.LocalDriverFactory.createWebDriver;

@Log4j2
//TODO Why Local
public class LocalDriverManager {
    private static final ThreadLocal<WebDriver> DRIVER_POOL = new ThreadLocal<>();

    public static WebDriver getWebDriver() {
        if (DRIVER_POOL.get() == null) {
            synchronized (LocalDriverManager.class) {
                if (DRIVER_POOL.get() == null) {
                    log.info("Setting WebDriver to DRIVER_POOL.");
                    //TODO Refactor using AbstractFactory pattern
                    DRIVER_POOL.set(createWebDriver());
                }
            }
        }
        log.info("Getting WebDriver from DRIVER_POOL.");
        return DRIVER_POOL.get();
    }

    public static void closeDriver() {
        log.info("Try to close WebDriver.");
        if (DRIVER_POOL.get() != null) {
            DRIVER_POOL.get().quit();
            DRIVER_POOL.remove();
            log.info("WebDriver was closed.");
        }
    }
}