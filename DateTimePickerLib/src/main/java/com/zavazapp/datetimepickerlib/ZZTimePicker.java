package com.zavazapp.datetimepickerlib;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class ZZTimePicker {
    private DateCallback dateCallback;
    private TimePickerDialog.OnTimeSetListener listener;
    private final Calendar c = Calendar.getInstance();
    private Context context;

    public ZZTimePicker(Context context) {
        this.context = context;
    }

    public ZZTimePicker withDateCallback(TimeCallback timeCallback) {
        listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                LocalTime lt = LocalTime.of(hourOfDay, minute);
                timeCallback.onTimeSet(lt, DateUtils.getStringFromLocalTime(lt));
            }
        };

        c.setTime(new Date(System.currentTimeMillis()));

        return this;
    }

    public ZZTimePicker show() {
        TimePickerDialog t = new TimePickerDialog(context, listener, c.get(Calendar.HOUR), c.get(Calendar.MINUTE), true);
        t.updateTime(c.get(Calendar.HOUR), c.get(Calendar.MINUTE));
        t.show();
        return this;
    }

    public ZZTimePicker withCalendar(Calendar c){
        this.c.setTime(c.getTime());
        return this;
    }

    public ZZTimePicker withDate(Date date){
        this.c.setTime(date);
        return this;
    }
    public ZZTimePicker withMillis(long millis){
        c.setTime(new Date(millis));
        return this;
    }

    public ZZTimePicker withLocalTime(LocalTime lt){
        c.set(Calendar.HOUR, lt.getHour());
        c.set(Calendar.MINUTE, lt.getMinute());
        return this;
    }

}
