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

    public static int parseInteger(String input) {
        if (input != null) {
            return Integer.parseInt(input);
        } else {
            return Integer.valueOf(input);
        }
    }

    public static boolean checkNullEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }
}
