package com.epam.webdriver;

import com.epam.utils.DataPropLoader;
import com.epam.webdriver.factory.impl.BrowserDriver;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DriverLoader {
//    TODO:
//    Refactor browser manager in scope of pattern module
    public static WebDriver createWebDriver() {

        DataPropLoader dataProp = new DataPropLoader();

        String webDriver = System.getProperty("browser", dataProp.getDefaultBrowser());

        log.info("Try to create driver - {}", webDriver);

        WebDriver driver = new BrowserDriver().getCreatedDriver(webDriver);

        driver.manage().window().maximize();

        log.info("Driver - '{}' was created.", webDriver);
        return driver;
    }
}
