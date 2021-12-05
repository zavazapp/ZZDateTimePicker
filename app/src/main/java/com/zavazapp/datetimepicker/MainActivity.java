package com.zavazapp.datetimepicker;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zavazapp.datetimepickerlib.TimeCallback;
import com.zavazapp.datetimepickerlib.ZZTimePicker;

import java.time.LocalTime;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar c = Calendar.getInstance();
    TextView t;
    LocalTime lt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = findViewById(R.id.textView);
        ImageView iv = findViewById(R.id.imageView);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZZTimePicker zzTimePicker =
                        new ZZTimePicker(MainActivity.this)
                        .withDateCallback(new TimeCallback() {
                            @Override
                            public void onTimeSet(LocalTime time, String stringTime) {
                                t.setText(stringTime);
                                lt = time;
                            }
                        })
                        .withLocalTime(lt == null ? LocalTime.now() : lt)
                        .show();

            }
        });
    }
}