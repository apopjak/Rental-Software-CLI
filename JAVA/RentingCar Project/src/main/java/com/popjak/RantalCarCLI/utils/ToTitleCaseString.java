package com.popjak.RantalCarCLI.utils;

public class ToTitleCaseString {

    public static String titleCase(String string) {
        return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
    }
}
