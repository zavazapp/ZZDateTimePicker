package com.zavazapp.datetimepickerlib;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.widget.DatePicker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class ZZDatePicker {
    private final DatePickerDialog d;
    private DateCallback dateCallback;

    public ZZDatePicker(Activity activity) {
        this.d =  new DatePickerDialog(activity);
    }

    public ZZDatePicker withCalendarFieldsCallback(DatePickerDialog.OnDateSetListener callback) {
        d.setOnDateSetListener(callback);
        return this;
    }

    public ZZDatePicker withDateCallback(DateCallback dateCallback) {
        d.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                LocalDate date = LocalDate.of(year, month+1, dayOfMonth);
                LocalDateTime ldt = date.atStartOfDay();
                long mills = ldt.toInstant(ZoneId.systemDefault().getRules().getOffset(ldt)).toEpochMilli();
                dateCallback.onDateSet(mills, DateUtils.getStringDateFromMills(date));
            }
        });
        return this;
    }

    public ZZDatePicker show() {
        d.show();
        return this;
    }

    public ZZDatePicker withCalendar(Calendar c){
        d.updateDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        return this;
    }

    public ZZDatePicker withDate(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        d.updateDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        return this;
    }
    public ZZDatePicker withMillis(long millis){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(millis));
        d.updateDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        return this;
    }

}
