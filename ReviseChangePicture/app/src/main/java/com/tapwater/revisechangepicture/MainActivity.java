package com.tapwater.revisechangepicture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    int[] images = new int[]
            {R.mipmap.ic_launcher};

    int currentImg = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout main = (LinearLayout) findViewById(R.id.root);
        final ImageView imageView = new ImageView(this);
        imageView.setImageResource(images[0]);
        main.addView(imageView);
        imageView.setImageResource(images[0]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(images[++currentImg % images.length]);
            }
        });


    }
}
