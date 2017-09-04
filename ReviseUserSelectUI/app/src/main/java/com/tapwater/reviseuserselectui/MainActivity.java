package com.tapwater.reviseuserselectui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinnerBox);
        String [] arr = {"唐僧","孙悟空","猪八戒","沙僧"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (MainActivity.this,R.layout.support_simple_spinner_dropdown_item,arr);
        spinner.setAdapter(arrayAdapter);
    }
}
