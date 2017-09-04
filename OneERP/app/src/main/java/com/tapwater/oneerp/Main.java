package com.tapwater.oneerp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Tapwater on 16-1-13.
 */
public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void action(View view)
    {
        switch (view.getId())
        {
            case R.id.buttonCreateProduct:
                Intent intent = new Intent(Main.this,Product.class);
                startActivity(intent);
                break;
        }
    }
}
