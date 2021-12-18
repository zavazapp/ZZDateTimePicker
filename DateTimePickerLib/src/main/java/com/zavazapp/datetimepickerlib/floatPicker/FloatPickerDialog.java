package com.zavazapp.datetimepickerlib.floatPicker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.zavazapp.datetimepickerlib.R;
import com.zavazapp.datetimepickerlib.utils.NumberUtils;

public class FloatPickerDialog {
    private Context context;
    private float result;
    private int decimals;
    private FloatCallback floatCallback;

    public FloatPickerDialog(Context context, float result, int decimals, FloatCallback floatCallback) {
        this.context = context;
        this.floatCallback = floatCallback;
        this.result = result;
        this.decimals = decimals;
    }

    public void show(float value ){
        AlertDialog a = new AlertDialog.Builder(context)
                .setPositiveButton(R.string.save_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        floatCallback.onFloatSet(NumberUtils.round(result, decimals), String.valueOf(NumberUtils.round(result, decimals)));
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();

        Window w = a.getWindow();
        if (w != null) {
            w.setBackgroundDrawableResource(R.drawable.shape_white_fill_radius_8dp);
        }

        a.setView(getDialogView(a.getListView(), value));
        a.show();
    }


    private View getDialogView(ListView rootView, float value) {
        View dialogView = LayoutInflater.from(context).inflate(R.layout.initial_measure_picker, rootView, false);

        EditText e1 = dialogView.findViewById(R.id.weightEditText);
        e1.setText(String.valueOf(NumberUtils.round(value, decimals)));

        Button reduceButton = dialogView.findViewById(R.id.reduceButton);
        Button raiseButton = dialogView.findViewById(R.id.raiseButton);

        raiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result += 0.1F;
                e1.setText(String.valueOf(NumberUtils.round(result, decimals)));

            }
        });

        reduceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result -= 0.1F;
                e1.setText(String.valueOf(NumberUtils.round(result, decimals)));
            }
        });

        FloatTextWatcher.setTextWatcher(e1, decimals, new OnTextChangedCallback() {
            @Override
            public void onTextChanged(float measure) {
                result = measure;
            }
        });

        return dialogView;
    }
}
