package com.tapwater.learn_14_fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Tapwater on 15-12-15.
 */
public class MainActivity2 extends Activity {

    private Button buttonChange;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_layout);

        buttonChange = (Button) findViewById(R.id.buttonChange);
        textView = (TextView) findViewById(R.id.textView);
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Change by fragment");
            }
        });

    }
}
