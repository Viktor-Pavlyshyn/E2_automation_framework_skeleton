package com.epam.businessobject;

public class BOProvider {
//    TODO:
//    Try to rewrite using Optional
//    If you need verify if null, there is a native Objects.isNull() method
//
//    TODO:
//    Rewrite usign Factory which will create by class name
    private GoogleSearchBO googleSearchBO;
    private ResultSearchGoogleBO resultSearchGoogleBO;

    public GoogleSearchBO getGoogleSearchBO() {
        return (googleSearchBO == null) ? googleSearchBO = new GoogleSearchBO() : googleSearchBO;
    }

    public ResultSearchGoogleBO getResultSearchGoogleBO() {
        return (resultSearchGoogleBO == null) ? resultSearchGoogleBO = new ResultSearchGoogleBO() : resultSearchGoogleBO;
    }
}
