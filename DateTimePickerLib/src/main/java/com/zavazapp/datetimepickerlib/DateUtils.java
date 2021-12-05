package com.zavazapp.datetimepickerlib;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String getStringDateFromMills(long mills) {
        return LocalDate.ofEpochDay(mills).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String getStringFromLocalTime(LocalTime lt) {
        return lt.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
