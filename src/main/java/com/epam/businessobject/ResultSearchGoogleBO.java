package com.epam.businessobject;

import com.epam.pageobject.ResultSearchGooglePage;

public class ResultSearchGoogleBO {

    private final ResultSearchGooglePage resultSearchGooglePage;

    public ResultSearchGoogleBO() {
        this.resultSearchGooglePage = new ResultSearchGooglePage();
    }

    public String getTitleValue(){
        //TODO hardcoded wikipedia. It should be possible to get any needed title by parameters
        return resultSearchGooglePage.getWikipediaTitle().getText();
    }
}
