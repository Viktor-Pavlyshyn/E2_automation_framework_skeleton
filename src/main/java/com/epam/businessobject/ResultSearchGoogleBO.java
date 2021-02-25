package com.epam.businessobject;

public class ResultSearchGoogleBO extends BaseBO {

    public String getLinkTextByPosition(int linkNumber) {
        return poProvider.getResultSearchGooglePage()
                .getListTextLinks()
                .get(linkNumber);
    }
}
