package com.epam.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.epam.config.PropConstant.DEFAULT_BROWSER;

public class DataPropLoader {
        private final String propertyPath = "src/main/resources/browser.properties";
        private Properties props = new Properties();

//    TODO:
//    Try to rewrite code using try with parameter to input input stream
//    Try to use more abstract type for field if there no needs to use more specific one for input stream
//    Create methods which will read on demand from different files. Not in constructor. For now it always
//    read browser.properties. You have to organize code to be able to reuse it without changes for other properties
        public DataPropLoader() {
            FileInputStream fis;

            try {
                fis = new FileInputStream(propertyPath);
                props.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getDefaultBrowser() {
            return props.getProperty(DEFAULT_BROWSER.PROP);
        }
}
