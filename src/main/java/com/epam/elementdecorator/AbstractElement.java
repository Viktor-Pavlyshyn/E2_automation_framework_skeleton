package com.epam.elementdecorator;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static com.epam.webdriver.DriverManager.getWebDriver;

public abstract class AbstractElement implements CustomElement {
    private final int WAIT_WITH_TIMEOUT = 60;
    private final int POLLING_EVERY_TIME = 5;
    protected Wait<WebDriver> fwait;
    protected WebElement element;

    public AbstractElement(WebElement element) {
        this.element = element;
        this.fwait = setDriverToFluentWait(getWebDriver());
    }

    public WebElement getWrappedElement() {
        return this.element;
    }

    public Wait<WebDriver> setDriverToFluentWait(WebDriver driver) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(WAIT_WITH_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(POLLING_EVERY_TIME))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }
}
