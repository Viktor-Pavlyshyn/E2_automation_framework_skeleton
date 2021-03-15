package com.epam.actions;

import com.epam.pageobject.POProvider;

public class BaseActions {

    protected POProvider poProvider;

    public BaseActions() {
        poProvider = new POProvider();
    }
}
