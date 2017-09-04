package com.tapwater.revisedateandtimepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int year ,month ,day, hour, minute;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        editText = (EditText) findViewById(R.id.editTextShow);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                MainActivity.this.year = i;
                MainActivity.this.month = i1;
                MainActivity.this.day = i2;
                showTime(year,month,day, hour,minute);
            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                MainActivity.this.hour = i;
                MainActivity.this.minute = i1;
                showTime(year,month,day,hour,minute);
            }
        });
    }

    public void showTime(int tempYear, int tempMonth, int tempDay, int tempHour, int tempMinute)
    {
        editText.setText(tempYear + "-" + tempMonth + "-" + tempDay + " " + tempHour + ":" + tempMinute);
    }
}
