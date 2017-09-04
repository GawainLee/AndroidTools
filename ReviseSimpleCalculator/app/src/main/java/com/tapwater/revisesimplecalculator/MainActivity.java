package com.tapwater.revisesimplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    GridLayout gridLayout;

    String[] chars = new String[]
            {
                    "7","8","9","//",
                    "4","5","6","x",
                    "1","2","3","-",
                    ".","0","=","+"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayout = (GridLayout) findViewById(R.id.root);
        for(int i = 0; i < chars.length; i++)
        {
            Button button = new Button(this);
            button.setText(chars[i]);
            button.setTextSize(30);
            button.setPadding(5,35,5,35);
            GridLayout.Spec rowSpec = GridLayout.spec(i / 4 + 2);
            GridLayout.Spec columnSpec = GridLayout.spec(i % 4);
            GridLayout.LayoutParams parame = new GridLayout.LayoutParams(rowSpec,columnSpec);
            parame.setGravity(Gravity.FILL);
            gridLayout.addView(button,parame);
        }
    }
}
