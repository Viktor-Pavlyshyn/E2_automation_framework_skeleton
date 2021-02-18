package com.epam.pageobject;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ResultSearchGooglePage extends AbstractPage {

    @FindBy(xpath = "//div[@id='res']//div[@class='g']")
    private WebElement firstLinkApple;
}