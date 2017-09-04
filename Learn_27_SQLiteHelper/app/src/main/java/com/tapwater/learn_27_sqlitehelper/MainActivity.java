package com.tapwater.learn_27_sqlitehelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonCreateDatabase, buttonUpdateDatabase, buttonInsertTable, buttonUpdateTable, buttonQueryTable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCreateDatabase = (Button) findViewById(R.id.button);
        buttonUpdateDatabase = (Button) findViewById(R.id.button2);
        buttonInsertTable = (Button) findViewById(R.id.button3);
        buttonUpdateTable = (Button) findViewById(R.id.button4);
        buttonQueryTable = (Button) findViewById(R.id.button5);

        buttonCreateDatabase.setOnClickListener(new CreateListener());
        buttonUpdateDatabase.setOnClickListener(new UpdateListener());
        buttonInsertTable.setOnClickListener(new InsertTableListener());
        buttonUpdateTable.setOnClickListener(new UpdateTableListener());
        buttonQueryTable.setOnClickListener(new QueryTableListener());

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


    class CreateListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(MainActivity.this,"test_database");
            SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getReadableDatabase();
        }
    }

    class UpdateListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(MainActivity.this,"test_database",2);
            SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getReadableDatabase();
        }
    }

    class InsertTableListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            ContentValues contentValues =new ContentValues();
            contentValues.put("id",1);
            contentValues.put("name","Gawain");
            MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(MainActivity.this,"test_database");
            SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
            sqLiteDatabase.insert("userTable",null,contentValues);
        }
    }

    class UpdateTableListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(MainActivity.this,"test_database");
            SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name","Gawain li");
            sqLiteDatabase.update("userTable",contentValues,"name=?",new String[]{"Gawain"});
        }
    }

    class QueryTableListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(MainActivity.this,"test_database");
            SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.query("userTable",new String[]{"id","name"},"id=?",new String[]{"1"},null,null,null);
            if (cursor != null)
            {
                while (cursor.moveToNext())
                {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    System.out.println("name: " + name);
                }
            }

        }
    }
}
