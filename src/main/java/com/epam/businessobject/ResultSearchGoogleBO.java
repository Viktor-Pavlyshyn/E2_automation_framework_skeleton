package com.epam.businessobject;

import com.epam.pageobject.ResultSearchGooglePage;

public class ResultSearchGoogleBO {

    private final ResultSearchGooglePage resultSearchGooglePage;

    public ResultSearchGoogleBO() {
        this.resultSearchGooglePage = new ResultSearchGooglePage();
    }

    public String getLinkTextByPosition(int linkNumber) {
        return resultSearchGooglePage.getListTextLinks().get(linkNumber);
    }
}
