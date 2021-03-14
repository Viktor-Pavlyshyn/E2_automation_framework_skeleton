package com.epam.utils.data;

public class SearchBuilder {
    private SearchData searchData;

    public SearchBuilder() {
        this.searchData = new SearchData();
    }

    public SearchBuilder addApple(String apple) {
        searchData.setApple(apple);
        return this;
    }

    public SearchBuilder addios(String ios) {
        searchData.setIos(ios);
        return this;
    }

    public SearchBuilder addMac(String mac) {
        searchData.setMac(mac);
        return this;
    }

    public SearchBuilder addIphone(String iphone) {
        searchData.setIphone(iphone);
        return this;
    }

    public String buildSearch() {
        return searchData.toString().trim();
    }
}
