package com.laptrinhjavaweb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String convertDateToString(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static String dateFormat(Date date) {
        return date != null ? new SimpleDateFormat("dd/MM/yyyy").format(date)
                            : new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

}
