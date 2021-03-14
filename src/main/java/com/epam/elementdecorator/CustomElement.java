package com.epam.elementdecorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public interface CustomElement {

    WebElement getWrappedElement();

    Wait<WebDriver> setDriverToFluentWait(WebDriver driver);
}
