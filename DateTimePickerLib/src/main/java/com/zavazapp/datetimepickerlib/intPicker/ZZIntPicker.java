package com.zavazapp.datetimepickerlib.intPicker;

import android.content.Context;

import com.zavazapp.datetimepickerlib.utils.Exceptions;

public class ZZIntPicker {
    private IntCallback floatCallback;
    private int value;
    private Context context;

    public ZZIntPicker(Context context) {
        this.context = context;
    }

    public ZZIntPicker withIntCallback(IntCallback floatCallback) {
        this.floatCallback = floatCallback;
        return this;
    }
    public ZZIntPicker setValue(int value){
        this.value = value;
        return this;
    }


    public void show() {
        validate();
        IntPickerDialog t = new IntPickerDialog(context, value, floatCallback);
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
