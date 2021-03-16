package com.epam.utils.data;

public class SearchBuilder {
    private SearchData searchData;

    public SearchBuilder() {
        this.searchData = new SearchData();
    }

    public SearchBuilder query(String query) {
        searchData.setQuery(query);
        return this;
    }

    public SearchData buildSearch() {
        return searchData;
    }
}
