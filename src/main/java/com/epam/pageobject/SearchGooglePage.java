package com.epam.pageobject;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SearchGooglePage extends AbstractPage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

}
