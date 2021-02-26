package com.epam.businessobject;

import java.util.Objects;

public class BOProvider {

//    TODO:
//    Rewrite usign Factory which will create by class name
    private GoogleSearchBO googleSearchBO;
    private ResultSearchGoogleBO resultSearchGoogleBO;

    public GoogleSearchBO getGoogleSearchBO() {
        return Objects.isNull(googleSearchBO) ? googleSearchBO = new GoogleSearchBO() : googleSearchBO;
    }

    public ResultSearchGoogleBO getResultSearchGoogleBO() {
        return Objects.isNull(resultSearchGoogleBO) ? resultSearchGoogleBO = new ResultSearchGoogleBO() : resultSearchGoogleBO;
    }
}
