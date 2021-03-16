package com.epam.elementdecorator.customdecorator;

import com.epam.elementdecorator.CustomElement;
import org.openqa.selenium.WebElement;

public class WrapperFactory {

    public static CustomElement createInstance(Class<CustomElement> clazz, WebElement element) {
        try {
            return clazz.getConstructor(WebElement.class).newInstance(element);
        } catch (Exception e) {
            throw new AssertionError("WebElement can't be represented as " + clazz);
        }
    }
}
