package com.zavazapp.datetimepickerlib.timePicker;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

import com.zavazapp.datetimepickerlib.utils.DateUtils;
import com.zavazapp.datetimepickerlib.utils.Exceptions;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class ZZTimePicker {
    private TimePickerDialog.OnTimeSetListener listener;
    private LocalDateTime ldt;
    private Context context;

    public ZZTimePicker(Context context) {
        this.context = context;
    }

    public ZZTimePicker withTimeCallback(TimeCallback timeCallback) {
        listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                ldt = ldt.withHour(hourOfDay);
                ldt = ldt.withMinute(minute);
                long mills = ldt.toInstant(ZoneId.systemDefault().getRules().getOffset(ldt)).toEpochMilli();
                timeCallback.onTimeSet(mills, DateUtils.getStringFromLocalTime(ldt));
            }
        };

        return this;
    }

    public void show() {
        TimePickerDialog t = new TimePickerDialog(context, listener, ldt.getHour(), ldt.getMinute(), true);
        t.show();
    }

    public ZZTimePicker withCalendar(Calendar c){
        this.ldt = LocalDateTime.ofInstant(c.toInstant(), ZoneId.systemDefault());
        return this;
    }

    public ZZTimePicker withDate(Date date){
        this.ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return this;
    }
    public ZZTimePicker withMillis(long millis){
        this.ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault());
        return this;
    }


}
