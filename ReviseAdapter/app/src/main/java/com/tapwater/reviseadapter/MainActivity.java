package com.tapwater.reviseadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] string = {"A","B","C","D"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (MainActivity.this,R.layout.support_simple_spinner_dropdown_item,string);
        ListView listView = (ListView) findViewById(R.id.listViewPlace);
        listView.setAdapter(arrayAdapter);
    }
}
