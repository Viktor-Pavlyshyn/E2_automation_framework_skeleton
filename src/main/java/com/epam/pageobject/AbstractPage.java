package com.epam.pageobject;

import com.epam.webdriver.DriverManager;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    public AbstractPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
}
