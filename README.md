# ZZDateTimePicker
Simple tool for date and time picker.

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
