package com.epam.actions;

public class ResultSearchActions extends BaseActions {

    public String getLinkTextByPosition() {
        return poProvider.getResultSearchGooglePage()
                .getTextTitleWikipedia();
    }
}
