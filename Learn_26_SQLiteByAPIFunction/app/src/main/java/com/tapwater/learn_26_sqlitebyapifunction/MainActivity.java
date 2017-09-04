package com.tapwater.learn_26_sqlitebyapifunction;

import android.content.ContentValues;
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

    private static final String TABLENAME = "userTable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase database = openOrCreateDatabase("myData.db",MODE_PRIVATE,null);
        database.execSQL("create table if not exists " + TABLENAME + "(_id integer primary key autoincrement, name text not null, sex text not null, age integer not null)");

        database.delete(TABLENAME,null,null);
        ContentValues values = new ContentValues();
        values.put("name", "Pet");
        values.put("sex", "Male");
        values.put("age", 11);
        database.insert(TABLENAME, null, values);
        values.clear();
        values.put("name", "Ken");
        values.put("sex", "Male");
        values.put("age", 91);
        database.insert(TABLENAME, null, values);
        values.clear();
        values.put("name", "William");
        values.put("sex", "Male");
        values.put("age", 41);
        database.insert(TABLENAME, null, values);
        values.clear();
        values.put("name", "Oven");
        values.put("sex", "Male");
        values.put("age", 21);
        database.insert(TABLENAME, null, values);
        values.clear();
        values.put("name", "Gawain");
        values.put("sex", "Male");
        values.put("age", 31);
        database.insert(TABLENAME, null, values);

        values.clear();
        values.put("sex", "Female");
        database.update(TABLENAME, values, "_id > ?", new String[]{"4"});
        database.delete(TABLENAME, "name like ?", new String[]{"%Oven%"});
        Cursor cursor = database.query(TABLENAME, null, "_id > ?", new String[]{"0"}, null, null, "age");

        if (cursor != null)
        {
            String[] columnNames = cursor.getColumnNames();
            while (cursor.moveToNext())
            {
                for(String columnName : columnNames)
                {
                    Log.i("lz",columnName + " " + cursor.getString(cursor.getColumnIndex(columnName)));
                }
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
