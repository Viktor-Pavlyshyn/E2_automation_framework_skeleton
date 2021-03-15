package com.epam.pageobject;

import com.epam.elementdecorator.InputElement;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.FindBy;

@Log4j2
@Getter
public class SearchGooglePage extends AbstractPage {

    @FindBy(xpath = "//input[@name='q']")
    private InputElement searchInput;

    public SearchGooglePage inputAndSubmit(String inputValue) {
        log.info("Perform search.");
        searchInput.clearAndSendKeys(inputValue);
        searchInput.getWrappedElement().submit();
        return this;
    }
}
