package com.tapwater.reviseactivemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu subMenu = menu.addSubMenu("Boot");
        subMenu.setIcon(R.drawable.image1);
        subMenu.setHeaderIcon(R.drawable.image1);
        subMenu.setHeaderTitle("Select Boot");
        MenuItem menuItem = subMenu.add("Check");
        menuItem.setIntent(new Intent(this,OtherActivity.class));

        return super.onCreateOptionsMenu(menu);
    }
}
