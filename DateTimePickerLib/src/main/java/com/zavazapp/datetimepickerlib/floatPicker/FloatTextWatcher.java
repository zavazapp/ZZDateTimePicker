package com.zavazapp.datetimepickerlib.floatPicker;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.zavazapp.datetimepickerlib.utils.NumberUtils;


public class FloatTextWatcher {

    public static void setTextWatcher(EditText e1, int decimals, OnTextChangedCallback onTextChangedCallback) {
        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null && !s.toString().isEmpty()) {
                    onTextChangedCallback.onTextChanged(NumberUtils.round(Float.parseFloat(s.toString()), decimals));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
