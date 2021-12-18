package com.zavazapp.datetimepicker;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zavazapp.datetimepickerlib.datePicker.DateCallback;
import com.zavazapp.datetimepickerlib.floatPicker.FloatCallback;
import com.zavazapp.datetimepickerlib.floatPicker.ZZFloatPicker;
import com.zavazapp.datetimepickerlib.timePicker.TimeCallback;
import com.zavazapp.datetimepickerlib.datePicker.ZZDatePicker;
import com.zavazapp.datetimepickerlib.timePicker.ZZTimePicker;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Calendar c = Calendar.getInstance();
    TextView dateTextView, dateMillisTextView, timeTextView, timeMillisTextView;
    long seatedTime;
    long seatedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTextView = findViewById(R.id.dateTextView);
        dateMillisTextView = findViewById(R.id.dateMillisTextView);

        timeTextView = findViewById(R.id.timeTextView);
        timeMillisTextView = findViewById(R.id.timeMillisTextView);

        ImageView dateImage = findViewById(R.id.dateImage);
        ImageView timeImage = findViewById(R.id.timeImage);

        Calendar c1 = Calendar.getInstance();

        dateImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        new ZZDatePicker(MainActivity.this)
                                .withDateCallback(new DateCallback() {
                                    @Override
                                    public void onDateSet(long mills, String stringDate) {
                                        dateTextView.setText(stringDate);
                                        dateMillisTextView.setText(String.valueOf(mills));
                                        c.setTime(new Date(mills));
                                        seatedDate = mills;
                                    }
                                })
                                .withCalendar(c)
                                //.withMillis(seatedDate == 0 ? System.currentTimeMillis() : seatedDate)
                                .show();
            }
        });


        timeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        new ZZTimePicker(MainActivity.this)
                                .withTimeCallback(new TimeCallback() {
                                    @Override
                                    public void onTimeSet(long mills, String stringTime) {
                                        timeTextView.setText(stringTime);
                                        timeMillisTextView.setText(String.valueOf(mills));
                                        c.setTime(new Date(mills));
                                        seatedTime = mills;
                                    }
                                })
                                .withCalendar(c)
                                //.withMillis(seatedTime == 0 ? System.currentTimeMillis() : seatedTime)
                                .show();
            }
        });

        ImageView floatImage = findViewById(R.id.floatImage);
        TextView floatTextView = findViewById(R.id.floatTextView);

        floatImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ZZFloatPicker(MainActivity.this)
                        .withValue(0.5f)
                        .withDecimals(3)
                        .withFloatCallback(new FloatCallback() {
                            @Override
                            public void onFloatSet(float floatNumber, String stringFloat) {
                                floatTextView.setText(stringFloat);
                            }
                        })
                        .show();
            }
        });
    }
}