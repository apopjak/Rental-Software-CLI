package com.popjak;

public class BasicMethods {

    public String toUpperCaseTextConverter(String string) {
        return string.toUpperCase();
    }

    public String toTitleCaseTextConverter(String string) {
        return string
                .substring(0,1).toUpperCase()
                + string.substring(1).toLowerCase();
    }

    public String[] emptyArray(){
        String[] arr = new String[5];
        return arr;
    }
}
