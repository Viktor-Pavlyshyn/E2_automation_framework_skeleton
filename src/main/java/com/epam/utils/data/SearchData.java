package com.epam.utils.data;

import lombok.Setter;

@Setter
public class SearchData {
    private String apple = "";
    private String ios = "";
    private String mac = "";
    private String iphone = "";

    @Override
    public String toString() {
        return apple + " " + ios + " " + mac + " " + iphone;
    }
}
