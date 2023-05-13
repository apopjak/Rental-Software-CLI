package com.popjak.CliWithTesting.util;

public class StringIntegerChecker {

    /*
    Class is checking if the passed string is in number format.
    If passed string is NOT in number format, it is going to return NULL
    */

    public static String stringIntegerChecker(String string) {
        if (string.isEmpty()) return null;
        try {
            Integer integer = Integer.parseInt(string);
            return String.valueOf(integer);
        } catch (NumberFormatException e) {
            System.out.println("❌ -> Incorrect number input");
            return null;
        }
    }
}
