# ZZDateTimePicker
Simple tool for date and time picker.

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
        
Add the dependency

        dependencies {
	        implementation 'com.github.zavazapp:ZZDateTimePicker:1.0.2'
	}

ZZDatePicker

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


ZZTimePicker

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
