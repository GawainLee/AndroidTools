package com.tapwater.reviseallbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

Button button1,button2,button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.shadowButton);
        button2 = (Button) findViewById(R.id.butto2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout_content);
        button = new Button(this);
        button.setText("Cool");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(button.getId());
            }
        });
        linearLayout.addView(button);


    }

    @Override
    public void onClick(View v) {

        System.out.println(v.getId() + " " + button1.getId() + " " + button2.getId() + " " + button.getId());

    }
}
