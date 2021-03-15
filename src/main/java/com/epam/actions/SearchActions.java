package com.epam.actions;

public class SearchActions extends BaseActions {

    public SearchActions inputAndSearch(String inputValue) {
        poProvider.getSearchGooglePage()
                .inputAndSubmit(inputValue);
        return this;
    }
}
