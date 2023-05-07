package com.laptrinhjavaweb.utils;

public class ValidateUtils {
    public static boolean isValid(Object obj) {
        if (obj == null) {
            return false;
        } else if (!obj.toString().equals("")) {
            return true;
        }
        return false;
    }
}
