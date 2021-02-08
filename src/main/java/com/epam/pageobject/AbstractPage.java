package com.epam.pageobject;

import com.epam.webdriver.LocalDriverManager;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    public AbstractPage() {
        PageFactory.initElements(LocalDriverManager.getWebDriver(), this);
    }
}
