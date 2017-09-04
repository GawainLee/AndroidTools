package com.tapwater.reviseactivityintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Tapwater on 16-12-15.
 */

public class otherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_activity);
        Intent intent = getIntent();
        Toast.makeText(otherActivity.this,intent.getStringExtra("Name"),Toast.LENGTH_LONG).show();

    }
}
