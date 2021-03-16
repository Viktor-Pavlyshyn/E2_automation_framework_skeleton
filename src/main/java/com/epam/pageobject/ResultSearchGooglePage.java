package com.epam.pageobject;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ResultSearchGooglePage extends AbstractPage {

    @FindBy(xpath = "//h3[@class=\"LC20lb DKV0Md\"][parent::a[@href=\"https://uk.wikipedia.org/wiki/Apple_Inc.\"]]")
    private WebElement titleWikipedia;

    public String getTextTitleWikipedia() {
        return titleWikipedia.getText();
    }
}