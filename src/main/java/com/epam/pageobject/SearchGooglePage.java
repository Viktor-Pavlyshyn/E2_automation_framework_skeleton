package com.epam.pageobject;

import com.epam.elementdecorator.InputElement;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.epam.utils.WaitUtils.fWaitUtil;

@Log4j2
@Getter
public class SearchGooglePage extends AbstractPage {

    @FindBy(xpath = "//input[@name='q']")
    private InputElement searchInput;
    @FindBy(xpath = "//div[@class=\"tfB0Bf\"]//input[@class=\"gNO89b\"]")
    private WebElement buttonSearch;

    public SearchGooglePage inputAndClickSearchButton(String inputValue) {
        log.info("Perform search.");
        searchInput.clearAndSendKeys(inputValue);
        fWaitUtil(ExpectedConditions.visibilityOf(buttonSearch)).click();
        return this;
    }
}
