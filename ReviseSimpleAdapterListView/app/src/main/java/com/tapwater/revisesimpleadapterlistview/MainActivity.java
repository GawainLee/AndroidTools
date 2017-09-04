package com.tapwater.revisesimpleadapterlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String [] names = {"Peter","Ann","Ken","William"};
    String [] descs = {"Music","Pain","Jump","Coding"};
    int [] images = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};
    List<Map<String,Object>> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listItems = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < names.length; i++)
        {
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("header",images[i]);
            listItem.put("name",names[i]);
            listItem.put("descs",descs[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.simple_item,
                new String[] {"name","header", "descs"}, new int[] {R.id.name,R.id.header,R.id.desc});
        listView = (ListView) findViewById(R.id.listViewRevise);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(names[i] + " Click");
            }
        });

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(names[i] + " Selected");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                
            }
        });
    }
}
