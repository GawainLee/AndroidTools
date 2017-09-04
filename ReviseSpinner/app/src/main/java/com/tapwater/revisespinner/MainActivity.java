package com.tapwater.revisespinner;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private ArrayList<Hero> mData;
    private Spinner spinner;
    private BaseAdapter myAdapter;

    private boolean spinnerFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;
        mData = new ArrayList<Hero>();
        mData.add(new Hero(R.drawable.image1,"Hero1"));
        mData.add(new Hero(R.drawable.image2,"Hero2"));
        mData.add(new Hero(R.drawable.image3,"Hero3"));
        mData.add(new Hero(R.drawable.image4,"Hero4"));
        mData.add(new Hero(R.drawable.image5,"Hero5"));
        mData.add(new Hero(R.drawable.image6,"Hero6"));
        mData.add(new Hero(R.drawable.image7,"Hero7"));
        mData.add(new Hero(R.drawable.image8,"Hero8"));
        mData.add(new Hero(R.drawable.image9,"Hero9"));
        mData.add(new Hero(R.drawable.image10,"Hero10"));
        mData.add(new Hero(R.drawable.image11,"Hero11"));
        mData.add(new Hero(R.drawable.image12,"Hero12"));
        myAdapter = new MyAdapter(mContext,mData);
        spinner = (Spinner) findViewById(R.id.spinnerPlace);
        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinnerFlag)
                {
                    Toast.makeText(mContext,"Hero " + (position + 1),Toast.LENGTH_LONG).show();
                    System.out.println(position);
                }
                else
                {
                    spinnerFlag = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
