package com.popjak;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ExtractorReport {

    public abstract Pattern getPattern();
    public abstract String getReportName();
    private String parse(String path) throws FileNotFoundException {

        String out = "";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        if (scanner.hasNext()) {
            scanner.nextLine();
        } else {
            return "Empty File";
        }
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            Matcher matcher = getPattern().matcher(nextLine);

            boolean matches = matcher.matches();
            if (matches) {
                out += nextLine + "\n";
            }
        }   return out.isBlank() ? "Empty file":out;
    }
    public void prepareAndSendReport(String path) throws FileNotFoundException {
        System.out.println("sending report " + getReportName() + " ...");
        System.out.println("email: ******");
        System.out.println(parse(path));
        System.out.println("Report sent " + getReportName());
    }
}
