package com.tapwater.learn_9_adapter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener{

    private ListView listView;
    private ArrayAdapter arrayAdapter;

    private SimpleAdapter simpleAdapter;
    private ArrayList<Map<String,Object>> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        String[] str = {"One","Two","Three","Four","Five"};
        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,str);
//        listView.setAdapter(arrayAdapter);
        arrayList = new ArrayList<Map<String,Object>>();

        simpleAdapter = new SimpleAdapter(this
                ,getData()
                ,R.layout.product_layout
                ,new String[]{"imageView","textViewProductName","textViewProductPrice"}
                ,new int[]{R.id.imageView,R.id.textViewProductName,R.id.textViewProductPrice});

        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);
    }

    private ArrayList<Map<String,Object>> getData()
    {
        for(int i = 0; i < 15; i++)
        {
            Map<String ,Object> map = new HashMap<>();
            map.put("imageView",R.mipmap.ic_launcher);
            map.put("textViewProductName","Product " + i);
            map.put("textViewProductPrice","$" + (i*100));
            arrayList.add(map);
        }
        return arrayList;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String productId = listView.getItemAtPosition(i) + "";
        Toast.makeText(this,"Product Name: " + i + " text: " + productId,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i)
        {
            //finger still on monitor and scroll moving
            case SCROLL_STATE_FLING:
                Map<String ,Object> map = new HashMap<>();
                map.put("imageView",R.mipmap.ic_launcher);
                map.put("textViewProductName","Product Add");
                map.put("textViewProductPrice","$" + (2*100));
                arrayList.add(map);
                simpleAdapter.notifyDataSetChanged();//refresh scroll
                break;
            //scroll stop moving
            case SCROLL_STATE_IDLE:
                break;
            //finger out of monitor and scroll moving
            case SCROLL_STATE_TOUCH_SCROLL:
                break;
        }

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

    }
}
