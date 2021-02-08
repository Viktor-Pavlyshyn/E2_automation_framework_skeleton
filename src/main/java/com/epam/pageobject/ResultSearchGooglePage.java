package com.epam.pageobject;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ResultSearchGooglePage extends AbstractPage {

    @FindBy(xpath = "//h2[@class='qrShPb kno-ecr-pt PZPZlf mfMhoc']/span")
    private WebElement wikipediaTitle;
}