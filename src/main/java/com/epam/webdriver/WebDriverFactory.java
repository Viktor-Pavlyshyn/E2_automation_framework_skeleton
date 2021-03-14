package com.epam.webdriver;

import com.epam.exeption.NoSuchWebDriverFactoryException;
import com.epam.utils.DataPropLoader;
import com.epam.webdriver.driverfactory.ChromeDriverFactory;
import com.epam.webdriver.driverfactory.FirefoxDriverFactory;
import org.openqa.selenium.WebDriver;

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public abstract class WebDriverFactory {

    protected abstract WebDriver createDriver();

    public static WebDriverFactory getCreatedDriver() {
        DataPropLoader dataProp = new DataPropLoader();
        String browser = System.getProperty("browser", dataProp.getDefaultBrowser());

        if (equalsIgnoreCase(browser, CHROME)) {
            return new ChromeDriverFactory();
        } else if (equalsIgnoreCase(browser, FIREFOX)) {
            return new FirefoxDriverFactory();
        } else {
            throw new NoSuchWebDriverFactoryException(String.format("%s are not supported.", browser));
        }
    }
}
