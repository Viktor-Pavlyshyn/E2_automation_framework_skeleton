package com.epam.businessobject;

import com.epam.pageobject.SearchGooglePage;

public class GoogleSearchBO {

    private final SearchGooglePage searchGooglePage;

    public GoogleSearchBO() {
        //TODO use factory to init page by class
        this.searchGooglePage = new SearchGooglePage();
    }

    public GoogleSearchBO inputAndSearch(String inputValue) {
        //TODO I prefer to keep single action in PageObject
        searchGooglePage.getSearchInput().sendKeys(inputValue);
        searchGooglePage.getSearchInput().submit();
        return this;
    }
}
