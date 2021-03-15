package com.epam.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class DataPropLoader {
    //    TODO:
//    Try to use more abstract type for field if there no needs to use more specific one for input stream
//    Create methods which will read on demand from different files. Not in constructor. For now it always
//    read browser.properties. You have to organize code to be able to reuse it without changes for other properties
    private static DataPropLoader dataPropLoader;
    private final Properties properties = new Properties();

    public static DataPropLoader getDataPropLoader() {
        if (Objects.isNull(dataPropLoader)) {
            DataPropLoader dataProp = new DataPropLoader();
            dataPropLoader = dataProp;
            dataProp.initDataPropLoader();
        }
        return dataPropLoader;
    }

    public void initDataPropLoader() {
        dataPropLoader.loadProperties("browser.properties");
    }

    public void loadProperties(final String resource) {
        Properties props = new Properties();
        try (InputStream inputStream = DataPropLoader.class.getClassLoader().getResourceAsStream(resource)) {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.putAll(props);
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
