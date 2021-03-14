package com.epam.elementdecorator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ButtonElement extends AbstractElement {

    public ButtonElement(WebElement element) {
        super(element);
    }

    public ButtonElement clickAfterVisibilityOf() {
        fwait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        return this;
    }

    public ButtonElement clickAfterElementToBeClickable() {
        fwait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return this;
    }

    public ButtonElement clickAfterDocumentReadyState() {
        fwait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
                .executeScript("return document.readyState").equals("complete"));
        element.click();
        return this;
    }
}
