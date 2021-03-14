package com.epam.businessobject;

public class ResultSearchGoogleActions extends BaseActions {

    public String getLinkTextByPosition(int linkNumber) {
        return poProvider.getResultSearchGooglePage()
                .getListTextLinks()
                .get(linkNumber);
    }
}
