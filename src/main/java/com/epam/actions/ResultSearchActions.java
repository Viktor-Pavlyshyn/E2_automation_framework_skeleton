package com.epam.actions;

public class ResultSearchActions extends BaseActions {

    public String getLinkTextByPosition(int linkNumber) {
        return poProvider.getResultSearchGooglePage()
                .getListTextLinks()
                .get(linkNumber);
    }
}
