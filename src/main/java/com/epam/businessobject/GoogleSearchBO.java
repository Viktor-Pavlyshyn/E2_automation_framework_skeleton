package com.epam.businessobject;

import com.epam.pageobject.SearchGooglePage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class GoogleSearchBO {

    private final SearchGooglePage searchGooglePage;

    public GoogleSearchBO() {
        //TODO use factory to init page by class
        this.searchGooglePage = new SearchGooglePage();
    }

    public GoogleSearchBO inputAndSearch(String inputValue) {
        searchGooglePage.inputAndSubmit(inputValue);
        log.info("Input value into google search and click button search.");
        return this;
    }
}
