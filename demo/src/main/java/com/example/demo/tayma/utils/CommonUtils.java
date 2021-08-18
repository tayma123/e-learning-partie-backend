package com.example.demo.tayma.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class that provides all common static java utility
 * methods.
 */
public final class CommonUtils {

    private static final DateFormat DATE_FORMAT_HH_mm = new SimpleDateFormat("HH:mm");

    private static final DateFormat DATE_FORMAT_yyyy_MM_dd = new SimpleDateFormat("yyyy.MM.dd");

    public static String getCurrentTimeStamp() {
        return DATE_FORMAT_HH_mm.format(new Date());
    }
    public static String getCurrentTimeStampForDialogs() throws ParseException {
        return DATE_FORMAT_yyyy_MM_dd.format(new Date());

    }
}
