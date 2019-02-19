package com.usermanagement.app.entiry;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {

    public static String convertDateToString(Date date) {
        SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static Date convertStringToDate(String date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale
                .ENGLISH);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            throw new AssertionError("Data format is incorrect, it should be " +
                    "yyyy-MM-dd");
        }
    }
}
