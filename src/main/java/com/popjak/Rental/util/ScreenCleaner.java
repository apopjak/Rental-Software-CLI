package com.popjak.Rental.util;

public class ScreenCleaner {

    public static void screenCleaner() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
