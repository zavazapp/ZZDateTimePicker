package com.zavazapp.datetimepickerlib.utils;

import java.math.BigDecimal;

public class NumberUtils {

    /*round float*/
    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
