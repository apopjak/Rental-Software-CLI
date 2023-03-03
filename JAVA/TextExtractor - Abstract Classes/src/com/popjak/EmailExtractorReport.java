package com.popjak;

import java.util.regex.Pattern;

public class EmailExtractorReport extends ExtractorReport{

    @Override
    public Pattern getPattern() {
        return Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?``{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }
    @Override
    public String getReportName() {
        return "Email Addresses";
    }
}
