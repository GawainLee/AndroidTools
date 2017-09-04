package com.tapwater.reviseexpanablelistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Group> arrayListGroup;
    private ArrayList<ArrayList<Item>> arrayListsItemList;
    private ArrayList<Item> arrayListItem;
    private Context context;
    private ExpandableListView expandableListView;
    private MyBaseExpandableListAdapter myBaseExpandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListViewPlace);
        context = MainActivity.this;

        arrayListGroup = new ArrayList<Group>();
        arrayListsItemList = new ArrayList<ArrayList<Item>>();
        arrayListGroup.add(new Group("One"));
        arrayListGroup.add(new Group("Two"));
        arrayListGroup.add(new Group("Three"));

        arrayListItem = new ArrayList<Item>();
        arrayListItem.add(new Item(R.drawable.image1,"1"));
        arrayListItem.add(new Item(R.drawable.image2,"2"));
        arrayListItem.add(new Item(R.drawable.image3,"3"));
        arrayListItem.add(new Item(R.drawable.image4,"4"));
        arrayListsItemList.add(arrayListItem);

        arrayListItem = new ArrayList<Item>();
        arrayListItem.add(new Item(R.drawable.image5,"5"));
        arrayListItem.add(new Item(R.drawable.image6,"6"));
        arrayListItem.add(new Item(R.drawable.image7,"7"));
        arrayListItem.add(new Item(R.drawable.image8,"8"));
        arrayListsItemList.add(arrayListItem);

        arrayListItem = new ArrayList<Item>();
        arrayListItem.add(new Item(R.drawable.image9,"9"));
        arrayListItem.add(new Item(R.drawable.image10,"10"));
        arrayListItem.add(new Item(R.drawable.image11,"11"));
        arrayListItem.add(new Item(R.drawable.image12,"12"));
        arrayListsItemList.add(arrayListItem);

        myBaseExpandableListAdapter = new MyBaseExpandableListAdapter(arrayListGroup,arrayListsItemList,context);
        expandableListView.setAdapter(myBaseExpandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(context,arrayListsItemList.get(groupPosition).get(childPosition).getHeroName(),Toast.LENGTH_LONG).show();
                return true;
            }
        });

    }
}
