package com.epam.elementdecorator;

import org.openqa.selenium.WebElement;

public class InputElement extends AbstractElement {

    public InputElement(WebElement element) {
        super(element);
    }

    public InputElement clearAndSendKeys(String keys) {
        element.clear();
        element.sendKeys(keys);
        return this;
    }
}