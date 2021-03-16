package com.epam.actions;

import com.epam.utils.data.SearchData;

public class SearchActions extends BaseActions {

    public SearchActions inputAndSearch(SearchData searchData) {
        poProvider.getSearchGooglePage()
                .inputAndSubmit(searchData.getQuery());
        return this;
    }
}
