package com.zavazapp.datetimepickerlib.floatPicker;

import android.content.Context;

import com.zavazapp.datetimepickerlib.utils.Exceptions;

public class ZZFloatPicker {
    private FloatCallback floatCallback;
    private float value;
    private int decimals;
    private Context context;

    public ZZFloatPicker(Context context) {
        this.context = context;
    }

    public ZZFloatPicker withFloatCallback(FloatCallback floatCallback) {
        this.floatCallback = floatCallback;
        return this;
    }
    public ZZFloatPicker withValue(float value){
        this.value = value;
        return this;
    }

    public ZZFloatPicker withDecimals(int decimals){
        this.decimals = decimals;
        return this;
    }

    public void show() {
        validate();
        FloatPickerDialog t = new FloatPickerDialog(context, value, decimals, floatCallback);
        t.show(value);
    }

    private void validate()  {
        if (context == null){
            throw new Exceptions("Context can not be null.");
        }
        if (floatCallback == null){
            throw new Exceptions("FloatCallback can not be null.");
        }

    }


}
