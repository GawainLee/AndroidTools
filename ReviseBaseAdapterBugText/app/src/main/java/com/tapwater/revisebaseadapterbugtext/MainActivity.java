package com.tapwater.revisebaseadapterbugtext;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ListItem> listItems = null;
    private Context mContext = null;
    private ListItemBaseAdapter listItemBaseAdapter = null;
    private ListView listViewItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        listViewItem = (ListView) findViewById(R.id.listViewPlace);
        listItems = new LinkedList<ListItem>();
        listItems.add(new ListItem(true,"Hello",R.drawable.image1));
        listItems.add(new ListItem(false,"OMG",R.drawable.image10));
        listItems.add(new ListItem(true,"Water",R.drawable.image5));
        listItemBaseAdapter = new ListItemBaseAdapter((LinkedList<ListItem>) listItems,mContext);
        listViewItem.setAdapter(listItemBaseAdapter);
    }
}
