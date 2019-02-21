package com.usermanagement.app.entiry;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";

    /**
     * Converts Date to Srting
     *
     * @return date as string in format in format yyyy-MM-dd HH:mm:ss
     */
    public static String convertDateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT + " " + TIME_FORMAT);
        return sdf.format(date);
    }

    /**
     * Converts date as String in format yyyy-MM-dd to Date
     *
     * @return Date object
     */
    static Date convertStringToDate(String date) {
        DateFormat format = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            String msg = "Data format is incorrect, it should be " + DATE_FORMAT;
            throw new AssertionError(msg, e);
        }
    }
}