package com.epam.webdriver.factoryimpltwo;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    private final ThreadLocal<WebDriver> DRIVER_POOL = new ThreadLocal<>();

    protected abstract WebDriver createDriver();

    public WebDriver getWebDriver() {
        if (DRIVER_POOL.get() == null) {
            synchronized (com.epam.webdriver.DriverManager.class) {
                if (DRIVER_POOL.get() == null) {
                    DRIVER_POOL.set(createDriver());
                }
            }
        }
        return DRIVER_POOL.get();
    }

    public void closeDriver() {
        if (DRIVER_POOL.get() != null) {
            DRIVER_POOL.get().quit();
            DRIVER_POOL.remove();
        }
    }
}
