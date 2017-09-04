package com.tapwater.revisesimplelistacticity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] arr1 = {"唐三藏","孙悟空","猪八戒","沙僧"};
    String[] arr2 = {"Java","Android","Object-C","Python","Html"};
    ListView listView1;
    ListView listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1 = (ListView) findViewById(R.id.listViewFirst);
        listView2 = (ListView) findViewById(R.id.listViewSecond);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arr1);
        listView1.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arr2);
        listView2.setAdapter(adapter2);
    }
}
