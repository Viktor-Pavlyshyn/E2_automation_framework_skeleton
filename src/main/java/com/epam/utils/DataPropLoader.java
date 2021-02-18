package com.epam.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.epam.config.PropConstant.DEFAULT_BROWSER;

public class DataPropLoader {
        private final String propertyPath = "src/main/resources/browser.properties";
        private Properties props = new Properties();

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
