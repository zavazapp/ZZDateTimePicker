package com.zavazapp.datetimepickerlib.intPicker;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;


public class IntTextWatcher {

    public static void setTextWatcher(EditText e1,  OnTextChangedCallback onTextChangedCallback) {
        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null && !s.toString().isEmpty()) {
                    onTextChangedCallback.onTextChanged(Integer.parseInt(s.toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
