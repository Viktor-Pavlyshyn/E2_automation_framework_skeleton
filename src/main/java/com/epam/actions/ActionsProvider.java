package com.epam.actions;

import java.util.Objects;

public class ActionsProvider {

    //    TODO:
    //    Rewrite usign Factory which will create by class name
    private SearchActions searchActions;
    private ResultSearchActions resultSearchActions;

    public SearchActions getSearchActions() {
        return Objects.isNull(searchActions) ? searchActions = new SearchActions() : searchActions;
    }

    public ResultSearchActions getResultSearchActions() {
        return Objects.isNull(resultSearchActions) ? resultSearchActions = new ResultSearchActions() : resultSearchActions;
    }
}
