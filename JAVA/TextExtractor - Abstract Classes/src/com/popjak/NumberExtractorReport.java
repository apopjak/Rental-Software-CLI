package com.popjak;

import java.util.regex.Pattern;

public class NumberExtractorReport extends ExtractorReport{

    @Override
    public Pattern getPattern() {
        return Pattern.compile("^[0-9]*$");
    }
    @Override
    public String getReportName() {
        return "Phone Numbers";
    }
}
