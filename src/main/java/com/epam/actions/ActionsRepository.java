package com.epam.actions;

public class ActionsRepository extends Repository {

    public SearchActions getSearchActions() {
        return get(SearchActions.class);
    }

    public ResultSearchActions getResultSearchActions() {
        return get(ResultSearchActions.class);
    }
}