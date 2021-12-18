package com.zavazapp.datetimepickerlib.utils;

import android.content.res.Resources;

import com.zavazapp.datetimepickerlib.R;

import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class PeriodUtils {

    public static String getPeriodString(Resources resources, long from, long to){
        PeriodFormatter periodFormatter = new PeriodFormatterBuilder()
                .appendYears().appendSuffix(" " + resources.getString(R.string.years))
                .appendSeparator(" ")
                .appendPrefix(" ")
                .appendMonths().appendSuffix(" " + resources.getString(R.string.months))
                .appendSeparator(" ")
                .appendPrefix(" ")
                .appendWeeks().appendSuffix(" " + resources.getString(R.string.weeks))
                .appendSeparator(" ")
                .appendPrefix(" ")
                .appendDays().appendSuffix(" " + resources.getString(R.string.days))
                .appendSeparator(" ")
                .appendPrefix(" ")
                //.appendHours().appendSuffix(" h ")
                //.appendMinutes().appendSuffix(" m ")
                //.appendSeconds().appendSuffix(" s ")
                .printZeroNever()
                .toFormatter();
        return periodFormatter.print(new Period(from, to));
    }
}
