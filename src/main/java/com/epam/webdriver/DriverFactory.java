package com.epam.webdriver;

import com.epam.utils.DataPropLoader;
import com.epam.webdriver.driver.Chrome;
import com.epam.webdriver.driver.Firefox;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

@Log4j2
public class DriverFactory {

    public static WebDriver createWebDriver() {
        DataPropLoader dataProp = new DataPropLoader();
        String browser = System.getProperty("browser", dataProp.getDefaultBrowser());

        if (equalsIgnoreCase(browser, CHROME)) {
            return new Chrome().getCreatedDriver();
        } else if (equalsIgnoreCase(browser, FIREFOX)) {
            return new Firefox().getCreatedDriver();
        }else {
            return new Chrome().getCreatedDriver();
        }
    }
}
