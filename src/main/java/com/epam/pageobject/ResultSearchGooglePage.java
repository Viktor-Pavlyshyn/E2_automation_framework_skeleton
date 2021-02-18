package com.epam.pageobject;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ResultSearchGooglePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResultText;

    public List<String> getListTextLinks() {
        return searchResultText.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}