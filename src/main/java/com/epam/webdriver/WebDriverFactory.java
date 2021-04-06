package com.epam.webdriver;

import com.epam.exeption.NoSuchWebDriverFactoryException;
import com.epam.webdriver.driverfactory.ChromeDriverFactory;
import com.epam.webdriver.driverfactory.FirefoxDriverFactory;
import org.openqa.selenium.WebDriver;
import sauce.labs.SauceLabsDriverFactory;

import static com.epam.utils.DataPropLoader.getBrowserProperty;
import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public abstract class WebDriverFactory {

    protected abstract WebDriver createDriver();

    public static WebDriverFactory getDriverFactory() {
        return getPlaceOfLaunch();
    }

    private static WebDriverFactory getPlaceOfLaunch() {
        String placeLaunch = System.getProperty("placeLaunch", getBrowserProperty("placeLaunch"));

        if (equalsIgnoreCase(placeLaunch, "localLaunch")) {
            return getLocalLaunch();
        } else if (equalsIgnoreCase(placeLaunch, "remoteLaunch")) {
            return getRemoteLaunch();
        } else {
            throw new RuntimeException();
        }
    }

    private static WebDriverFactory getRemoteLaunch() {
        return new SauceLabsDriverFactory();
    }

    private static WebDriverFactory getLocalLaunch() {
        String browser = System.getProperty("browser", getBrowserProperty("browser"));

        if (equalsIgnoreCase(browser, CHROME)) {
            return new ChromeDriverFactory();
        } else if (equalsIgnoreCase(browser, FIREFOX)) {
            return new FirefoxDriverFactory();
        } else {
            throw new NoSuchWebDriverFactoryException(String.format("%s are not supported.", browser));
        }
    }
}
