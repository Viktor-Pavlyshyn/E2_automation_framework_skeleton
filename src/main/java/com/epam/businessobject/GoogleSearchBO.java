package com.epam.businessobject;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class GoogleSearchBO extends BaseBO {
    //    TODO:
//   -  From my perspective it is more clear to name business object like Actions Ex, GoogleSearchActions
//   -  I preferer PageObject describe via atomic operations and then combine it in Actions
//      page.setSerchRequest();
//      page.search();
//    -  Separate log.info in corresponding atomic actions in page class
//    setSerchRequest() -> log.info("Set search keyword to search field")
//    search() -> log.info("Click 'Search' button")
//    It helps to avoid copy-past in future for every method usage.
//    If you wish print action to log make sure it will not be redundant.
//    Something like "Perform search" instead of '"Input value into google search and click button search."'
    public GoogleSearchBO inputAndSearch(String inputValue) {
        poProvider.getSearchGooglePage()
                .inputAndSubmit(inputValue);

        log.info("Input value into google search and click button search.");
        return this;
    }
}
