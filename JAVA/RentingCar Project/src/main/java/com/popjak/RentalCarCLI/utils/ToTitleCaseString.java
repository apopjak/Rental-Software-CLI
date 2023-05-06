package com.popjak.RentalCarCLI.utils;

public class ToTitleCaseString {

    // Title case any string
    public static String titleCase(String string) {
        return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
    }
}
