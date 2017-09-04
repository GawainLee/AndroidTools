package com.tapwater.revisesimpleadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String[] names = {"Gawain","Jimmy","Jessie","Patty"};
    private String[] singes = {"123","456","789","10"};
    private int[] images = {R.drawable.image1,R.drawable.image10,R.drawable.image5,R.drawable.image6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i<names.length;i++)
        {
            Map<String,Object> item = new HashMap<String,Object>();
            item.put("name",names[i]);
            item.put("singe",singes[i]);
            item.put("head",images[i]);
            list.add(item);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter
                (getApplicationContext(),list,R.layout.list_item,
                        new String[]{"name","singe","head"},
                        new int[]{R.id.textViewName,R.id.textViewSinge,R.id.imageViewPlace});
        ListView listView = (ListView) findViewById(R.id.listViewPlace);
        listView.setAdapter(simpleAdapter);
    }
}
