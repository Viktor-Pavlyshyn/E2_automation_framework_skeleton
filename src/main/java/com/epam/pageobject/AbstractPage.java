package com.epam.pageobject;

import com.epam.elementdecorator.customdecorator.CustomFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static com.epam.webdriver.DriverManager.getWebDriver;

public abstract class AbstractPage {

    public AbstractPage() {
        PageFactory.initElements(new CustomFieldDecorator(getWebDriver()), this);
    }
}
