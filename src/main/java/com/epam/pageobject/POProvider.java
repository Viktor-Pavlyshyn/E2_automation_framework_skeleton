package com.epam.pageobject;

public class POProvider {

    private SearchGooglePage searchGooglePage;
    private ResultSearchGooglePage resultSearchGooglePage;

    public ResultSearchGooglePage getResultSearchGooglePage() {
        return (resultSearchGooglePage == null) ? resultSearchGooglePage = new ResultSearchGooglePage() : resultSearchGooglePage;
    }

    public SearchGooglePage getSearchGooglePage() {
        return (searchGooglePage == null) ? searchGooglePage = new SearchGooglePage() : searchGooglePage;
    }
}
