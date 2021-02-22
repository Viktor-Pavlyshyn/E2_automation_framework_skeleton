package com.epam.businessobject;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class GoogleSearchBO extends BaseBO {

    public GoogleSearchBO inputAndSearch(String inputValue) {
        poProvider.getSearchGooglePage()
                .inputAndSubmit(inputValue);

        log.info("Input value into google search and click button search.");
        return this;
    }
}
