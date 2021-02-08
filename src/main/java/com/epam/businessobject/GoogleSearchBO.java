package com.epam.businessobject;

import com.epam.pageobject.SearchGooglePage;

public class GoogleSearchBO {
    private final SearchGooglePage searchGooglePage;

    public GoogleSearchBO() {
        this.searchGooglePage = new SearchGooglePage();
    }

    public GoogleSearchBO inputAndSearch(String inputValue) {

        searchGooglePage.getSearchInput().sendKeys(inputValue);
        searchGooglePage.getSearchInput().submit();

        return this;
    }
}
