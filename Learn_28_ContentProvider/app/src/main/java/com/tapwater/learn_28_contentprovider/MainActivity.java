package com.tapwater.learn_28_contentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(Contacts.CONTENT_URI, new String[]{Contacts._ID, Contacts.DISPLAY_NAME}, null, null, null);

        if (cursor != null)
        {
            int a = cursor.getColumnCount();
            int b = cursor.getCount();
            while (cursor.moveToNext())
            {
                int id = cursor.getInt(cursor.getColumnIndex(Contacts._ID));
                Log.i("lz","id: " + id);
                Log.i("lz", cursor.getString(cursor.getColumnIndex(Contacts.DISPLAY_NAME)));
                Cursor cursor1 = contentResolver.query(Phone.CONTENT_URI, new String[]{Phone.NUMBER, Phone.TYPE}, Phone.CONTACT_ID + "=" + id, null, null);
                if (cursor1 != null)
                {
                    while (cursor1.moveToNext())
                    {
                        int type = cursor1.getInt(cursor1.getColumnIndex(Phone.TYPE));
                        if (type == Phone.TYPE_HOME)
                        {
                            Log.i("lz","Home Number: " + cursor1.getString(cursor1.getColumnIndex(Phone.NUMBER)));
                        }
                        else if (type == Phone.TYPE_MOBILE)
                        {
                            Log.i("lz","Mobile Number: " + cursor1.getString(cursor1.getColumnIndex(Phone.NUMBER)));
                        }
                    }
                    cursor1.close();
                }
                Cursor cursor2 = contentResolver.query(Email.CONTENT_URI,new String[]{Email.TYPE,Email.DATA},Email.CONTACT_ID + "=" + id,null,null );
                if (cursor2 != null)
                {
                    while (cursor2.moveToNext())
                    {
                        int emailType = cursor2.getInt(cursor2.getColumnIndex(Email.TYPE));
                        if (emailType == Email.TYPE_WORK)
                        {
                            Log.i("lz","Working Email: " + cursor2.getString(cursor2.getColumnIndex(Email.DATA)));
                        }
                        else
                        {
                            Log.i("lz"," other Email: " + cursor2.getString(cursor2.getColumnIndex(Email.DATA)));
                        }
                    }
                    cursor2.close();
                }
            }
            cursor.close();
        }



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
