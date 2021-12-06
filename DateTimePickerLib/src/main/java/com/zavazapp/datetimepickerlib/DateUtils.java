package com.zavazapp.datetimepickerlib;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String getStringDateFromMills(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String getStringFromLocalTime(LocalDateTime lt) {
        return lt.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
