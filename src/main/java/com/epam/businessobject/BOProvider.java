package com.epam.businessobject;

public class BOProvider {

    private GoogleSearchBO googleSearchBO;
    private ResultSearchGoogleBO resultSearchGoogleBO;

    public GoogleSearchBO getGoogleSearchBO() {
        return (googleSearchBO == null) ? googleSearchBO = new GoogleSearchBO() : googleSearchBO;
    }

    public ResultSearchGoogleBO getResultSearchGoogleBO() {
        return (resultSearchGoogleBO == null) ? resultSearchGoogleBO = new ResultSearchGoogleBO() : resultSearchGoogleBO;
    }
}
