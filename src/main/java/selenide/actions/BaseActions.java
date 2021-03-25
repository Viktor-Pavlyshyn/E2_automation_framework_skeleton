package selenide.actions;

import selenide.page.object.POProvider;

public class BaseActions {

    protected POProvider poProvider;

    public BaseActions() {
        poProvider = new POProvider();
    }
}
