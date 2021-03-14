package com.epam.businessobject;

public class GoogleSearchActions extends BaseActions {

    public GoogleSearchActions inputAndSearch(String inputValue) {
        poProvider.getSearchGooglePage()
                .inputAndSubmit(inputValue);
        return this;
    }
}
