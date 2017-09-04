package com.tapwater.revisequickcontactbadge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {

    QuickContactBadge quickContactBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quickContactBadge = (QuickContactBadge) findViewById(R.id.quickOMG);
        quickContactBadge.assignContactFromPhone("0755-13902932193",false);
    }
}
