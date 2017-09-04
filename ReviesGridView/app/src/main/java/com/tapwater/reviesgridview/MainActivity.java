package com.tapwater.reviesgridview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private GridView gridView;
    private BaseAdapter baseAdapterGrid =null;
    private ArrayList<Icon> arrayListIcon = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        gridView = (GridView) findViewById(R.id.gridViewPlace);
        arrayListIcon = new ArrayList<Icon>();
        arrayListIcon.add(new Icon(R.drawable.image1,"Name1"));
        arrayListIcon.add(new Icon(R.drawable.image2,"Name2"));
        arrayListIcon.add(new Icon(R.drawable.image3,"Name3"));
        arrayListIcon.add(new Icon(R.drawable.image4,"Name4"));
        arrayListIcon.add(new Icon(R.drawable.image5,"Name5"));
        arrayListIcon.add(new Icon(R.drawable.image6,"Name6"));
        arrayListIcon.add(new Icon(R.drawable.image7,"Name7"));
        arrayListIcon.add(new Icon(R.drawable.image8,"Name8"));
        arrayListIcon.add(new Icon(R.drawable.image9,"Name9"));
        arrayListIcon.add(new Icon(R.drawable.image10,"Name10"));
        arrayListIcon.add(new Icon(R.drawable.image11,"Name11"));
        arrayListIcon.add(new Icon(R.drawable.image12,"Name12"));
        baseAdapterGrid = new MyAdapter(arrayListIcon,mContext);

        gridView.setAdapter(baseAdapterGrid);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext,"Number" + (position + 1),Toast.LENGTH_LONG).show();
            }
        });

    }
}
