package com.epam.businessobject;

import java.util.Objects;

public class ActionsProvider {

    //    TODO:
    //    Rewrite usign Factory which will create by class name
    private GoogleSearchActions googleSearchActions;
    private ResultSearchGoogleActions resultSearchGoogleActions;

    public GoogleSearchActions getGoogleSearchBO() {
        return Objects.isNull(googleSearchActions) ? googleSearchActions = new GoogleSearchActions() : googleSearchActions;
    }

    public ResultSearchGoogleActions getResultSearchGoogleBO() {
        return Objects.isNull(resultSearchGoogleActions) ? resultSearchGoogleActions = new ResultSearchGoogleActions() : resultSearchGoogleActions;
    }

}
