package com.zavazapp.datetimepickerlib;

import java.time.LocalTime;

public interface TimeCallback {
    void onTimeSet(LocalTime time, String stringTime);
}
