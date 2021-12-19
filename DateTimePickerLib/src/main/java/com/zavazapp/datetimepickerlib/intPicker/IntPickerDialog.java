package com.zavazapp.datetimepickerlib.intPicker;

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

public class IntPickerDialog {
    private Context context;
    private int result;
    private IntCallback intCallback;
    private final int increment = 1;

    public IntPickerDialog(Context context, int result, IntCallback intCallback) {
        this.context = context;
        this.intCallback = intCallback;
        this.result = result;
    }

    public void show(int value ){
        AlertDialog a = new AlertDialog.Builder(context)
                .setPositiveButton(R.string.save_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intCallback.onIntSet(result, String.valueOf(result));
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


    private View getDialogView(ListView rootView, int value) {
        View dialogView = LayoutInflater.from(context).inflate(R.layout.int_measure_picker, rootView, false);

        EditText e1 = dialogView.findViewById(R.id.weightEditText);
        e1.setText(String.valueOf(value));

        Button reduceButton = dialogView.findViewById(R.id.reduceButton);
        Button raiseButton = dialogView.findViewById(R.id.raiseButton);

        raiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result += increment;
                e1.setText(String.valueOf(result));

            }
        });

        reduceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result -= increment;
                e1.setText(String.valueOf(result));
            }
        });

        IntTextWatcher.setTextWatcher(e1, new OnTextChangedCallback() {
            @Override
            public void onTextChanged(int measure) {
                result = measure;
            }
        });

        return dialogView;
    }
}
