package com.tapwater.reviseimageswitcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    int [] images = new int[]
            {
                R.drawable.image1,R.drawable.image2,
                    R.drawable.image3,R.drawable.image4,
                    R.drawable.image5,R.drawable.image6,
                    R.drawable.image7,R.drawable.image8,
                    R.drawable.image9,R.drawable.image10,
                    R.drawable.image11,R.drawable.image12
            };

    ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < images.length; i++)
        {
            Map<String,Object> listItem = new HashMap<String, Object>();
            listItem.put("image",images[i]);
            listItems.add(listItem);
        }
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams
                        (new ImageSwitcher.LayoutParams
                                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                        );
                return imageView;
            }
        });
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                MainActivity.this,listItems,R.layout.cell,new String[]{"image"},new int[]{R.id.imageView}
        );
        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imageSwitcher.setImageResource(images[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imageSwitcher.setImageResource(images[i]);
            }
        });
    }
}
