package com.epam.elementdecorator;

import org.openqa.selenium.WebElement;

public abstract class AbstractElement implements CustomElement {
    protected WebElement element;

    public AbstractElement(WebElement element) {
        this.element = element;
    }

    public WebElement getWrappedElement() {
        return this.element;
    }
}
