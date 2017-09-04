package com.tapwater.revisetoast;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSimple = (Button) findViewById(R.id.buttonSimple);
        buttonSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(MainActivity.this,"Simple Toast",Toast.LENGTH_LONG);
                toast.show();
            }
        });

        Button buttonCom = (Button) findViewById(R.id.buttonCom);
        buttonCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toastCom = new Toast(MainActivity.this);
                toastCom.setGravity(Gravity.CENTER,0,0);
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.image10);
                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                linearLayout.addView(imageView);
                TextView textView = new TextView(MainActivity.this);
                textView.setText("Com");
                textView.setTextColor(Color.BLUE);
                textView.setTextSize(20);
                linearLayout.addView(textView);
                toastCom.setView(linearLayout);
                toastCom.setDuration(Toast.LENGTH_LONG);
                toastCom.show();

            }
        });
    }
}
