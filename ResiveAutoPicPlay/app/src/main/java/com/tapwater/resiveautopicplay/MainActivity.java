package com.tapwater.resiveautopicplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int [] imageIds = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};

    AdapterViewFlipper adapterViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.adapterViewFlipper);
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(imageIds[i]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams
                        (new ViewGroup.LayoutParams
                                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        adapterViewFlipper.setAdapter(baseAdapter);
    }

    public void prev(View source)
    {
        adapterViewFlipper.showPrevious();
        adapterViewFlipper.stopFlipping();
    }

    public void next(View source)
    {
        adapterViewFlipper.showNext();
        adapterViewFlipper.stopFlipping();
    }

    public void auto(View source)
    {
        adapterViewFlipper.startFlipping();
    }
}
