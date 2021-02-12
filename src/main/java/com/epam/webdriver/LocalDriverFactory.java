package com.epam.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static com.epam.config.WaitTime.IMPLICITLY_TIME;

@Log4j2
public class LocalDriverFactory {

    public static WebDriver createWebDriver() {
        WebDriver driver;

        //TODO Move default browser name to property file
        String webDriver = System.getProperty("browser", "chrome");

        log.info("Try to create driver - {}", webDriver);

        if (isSame(webDriver, "firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (isSame(webDriver, "chrome")) {
            WebDriverManager.chromedriver().setup();
            //TODO Add several common options by default
            driver = new ChromeDriver();
        } else {
            //TODO If you support default value it might make sense return default driver
            log.error("This is an incorrect webDriver input - " + webDriver);
            throw new WebDriverException("This is an incorrect webDriver input - " + webDriver);
        }

        driver.manage().window().maximize();
        //TODO Do not use implicity wait by default. Try to update you pages to use explicit wait
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_TIME, TimeUnit.SECONDS);

        log.info("Driver - '{}' was created.", webDriver);
        return driver;
    }

    //TODO Try always investigate maybe someone already implemented what you need
    // apache.commons.lang3 -> StringUtils
    private static boolean isSame(String val1, String val2) {
        return val1 != null && val1.equalsIgnoreCase(val2);
    }
}
