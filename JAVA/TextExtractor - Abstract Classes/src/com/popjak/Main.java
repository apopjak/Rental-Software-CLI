package com.popjak;

import java.io.FileNotFoundException;

public class Main {
    static String path = "src/data.txt" ;
    public static void main(String[] args) throws FileNotFoundException {
        new EmailExtractorReport().prepareAndSendReport(path);

        new NumberExtractorReport().prepareAndSendReport(path);

    }
}