package com.epam.businessobject;

import com.epam.pageobject.POProvider;

public class BaseBO {

    protected POProvider poProvider;

    public BaseBO() {
        poProvider = new POProvider();
    }
}
