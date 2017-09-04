package com.tapwater.learn_25_sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase database = openOrCreateDatabase("myData.db",MODE_PRIVATE,null);
        database.execSQL(
                "create table if not exists userTable(" +
                        "_id integer primary key autoincrement" +
                        ", name text not null" +
                        ", age integer not null" +
                        ", sex text not null)");
        database.execSQL("insert into userTable( name, sex, age) values ( 'Gawain', 'Male', 29)");
//        database.execSQL("insert into userTable( name, sex, age) values ( 'Ann', 'Female', 18)");
//        database.execSQL("insert into userTable( name, sex, age) values ( 'Ken', 'Male', 18)");
//        database.execSQL("insert into userTable( name, sex, age) values ( 'Sue', 'Female', 18)");

        Cursor cursor = database.rawQuery("select * from userTable",null);
        if (cursor != null)
        {
            while (cursor.moveToNext())
            {
                Log.i("lz","_id: " + cursor.getInt(cursor.getColumnIndex("_id")));
                Log.i("lz","name: " + cursor.getString(cursor.getColumnIndex("name")));
                Log.i("lz","Sex: " + cursor.getString(cursor.getColumnIndex("sex")));
                Log.i("lz","age: " + cursor.getInt(cursor.getColumnIndex("age")));
            }
            cursor.close();
        }
        database.close();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
