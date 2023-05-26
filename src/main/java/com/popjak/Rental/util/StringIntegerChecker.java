package com.popjak.Rental.util;

public class StringIntegerChecker {

    /*
    Class is checking if the passed string is in number format.
    If passed string is NOT in number format, it is going to return NULL
    */

    public static String stringIntegerChecker(String string) {
        if (string.isEmpty()) {
            return null;
        }
        if (!string.chars().allMatch(Character::isDigit)) {
            System.out.println("❌ Incorrect digit");
            return null;
        }
        return string;
    }
}
