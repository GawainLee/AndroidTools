package com.tapwater.revisepricepick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    NumberPicker numberPickerLow, numberPickerHeight;
    int minPrice = 25;
    int maxPrice = 75;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberPickerLow = (NumberPicker) findViewById(R.id.numberPriceLow);
        numberPickerHeight = (NumberPicker) findViewById(R.id.numberPriceHeight);
        numberPickerLow.setMinValue(10);
        numberPickerLow.setMaxValue(50);
        numberPickerLow.setValue(minPrice);
        numberPickerLow.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                minPrice = i1;
                showSelectPrice();
            }
        });
        numberPickerHeight.setMinValue(60);
        numberPickerHeight.setMaxValue(100);
        numberPickerHeight.setValue(maxPrice);
        numberPickerHeight.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                maxPrice = i1;
                showSelectPrice();
            }
        });
    }

    public void showSelectPrice()
    {
        Toast.makeText(MainActivity.this,"Low : " + minPrice + " Height : " + maxPrice, Toast.LENGTH_LONG).show();
    }
}
