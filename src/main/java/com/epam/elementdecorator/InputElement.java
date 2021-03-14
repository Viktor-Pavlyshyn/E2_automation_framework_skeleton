package com.epam.elementdecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InputElement extends AbstractElement {

    public InputElement(WebElement element) {
        super(element);
    }

    public InputElement setTextAfterDocumentReadyState(String value) {
        fwait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
                .executeScript("return document.readyState").equals("complete"));
        element.sendKeys(value);
        return this;
    }

    public InputElement sendKeysAfterElementToBeClickable(String value) {
        fwait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(value);
        return this;
    }

    public InputElement cleanBeforeSendKeys(String keys) {
        element.clear();
        element.sendKeys(keys);
        return this;
    }

    public InputElement setTextAfterPresenceOfAllElementsLocatedBy(String value, String xpath) {
        fwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
        element.sendKeys(value);
        return this;
    }
}