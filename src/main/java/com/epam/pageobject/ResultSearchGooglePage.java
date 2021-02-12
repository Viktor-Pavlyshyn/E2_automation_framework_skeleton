package com.epam.pageobject;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ResultSearchGooglePage extends AbstractPage {

    //TODO it is not wiki locator
    // //div[@id='res']//div[@class='g']
    // section which might contains other elements
    @FindBy(xpath = "//h2[@class='qrShPb kno-ecr-pt PZPZlf mfMhoc']/span")
    private WebElement wikipediaTitle;
}