package com.epam.actions;

public class ResultSearchActions extends BaseActions {

    public String getTextTitleWikipedia() {
        return poProvider.getResultSearchGooglePage()
                .getTextTitleWikipedia();
    }
}
