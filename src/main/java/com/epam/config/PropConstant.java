package com.epam.config;

public enum PropConstant {
//    TODO:
//    Discuss about ENUM. Unclear functional purpose

    DEFAULT_BROWSER("browser");

    public String PROP;

    //    TODO:
//    ENUM is a kind of of constant with specific type, which helps to control where to use.
//    From my perspective it is redundant to use constant in enum
    PropConstant(String PROP) {
        this.PROP = PROP;
    }
}
