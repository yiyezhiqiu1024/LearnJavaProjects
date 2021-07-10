package com.sl.common.mapStruct;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

public class MapStructFormatter {

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface Date2Millis {}

    @Date2Millis
    public static Long date2Millis(Date date) {
        if (date == null) return null;
        return date.getTime();
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface Millis2Date {}

    @Millis2Date
    public static Date millis2Date(Long millis) {
        if (millis == null) return null;
        return new Date(millis);
    }


}
