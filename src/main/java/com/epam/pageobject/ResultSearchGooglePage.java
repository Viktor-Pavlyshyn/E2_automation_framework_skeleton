package com.epam.pageobject;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ResultSearchGooglePage extends AbstractPage {
//    TODO:
//    div[@Class='g'] is complex section with a lot of inner elements. It is not just link.
//    Please rename methods like getResultSectionsText() for now
//    We will refactor it in future modules
//
//    P.S Pay attention for naming from English perspective.
//    getListTextLinks() sounds like we expect list of links named like 'List text'
//    getLinksTextList() is better
    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResultText;

    public List<String> getListTextLinks() {
        return searchResultText.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}