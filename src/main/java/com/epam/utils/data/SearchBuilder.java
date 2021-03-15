package com.epam.utils.data;

public class SearchBuilder {
    private SearchData searchData;

    public SearchBuilder() {
        this.searchData = new SearchData();
    }

    public SearchBuilder addApple(String query) {
        searchData.setQuery(searchData.getQuery() + query);
        return this;
    }

    public SearchData buildSearch() {
        return searchData;
    }
}
