package com.laptrinhjavaweb.utils;

import java.util.Map;

public class MapUtils {

    public static <T> T getObject(Map<String, Object> params, String key, Class<T> tClass) { // T :
        Object object = params.getOrDefault(key, null);
        if (object != null) {
            if (tClass.getTypeName().equals("java.lang.Long")) {
                object = object != "" ? Long.valueOf(object.toString()) : null;
            } else if (tClass.getTypeName().equals("java.lang.Integer")) {
                object = object != "" ? Integer.valueOf(object.toString()) : null;
            } else if (tClass.getTypeName().equals("java.lang.String")) {
                object = object.toString();
            }
            return tClass.cast(object);
        }
        return null;
    }
}
