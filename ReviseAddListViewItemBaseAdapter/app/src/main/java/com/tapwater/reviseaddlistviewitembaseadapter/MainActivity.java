package com.tapwater.reviseaddlistviewitembaseadapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Data> listItem;
    private MyAdapter myAdapter;
    private ListView listView;
    private Context mContext;

    private int num = 0;
    public int selectNum = 0;
    private Button buttonAdd,buttonAddPosition,buttonDelete,buttonDeletePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;
        listView = (ListView) findViewById(R.id.listViewPlace);
        listItem = new LinkedList<Data>();
        myAdapter = new MyAdapter(mContext,(LinkedList<Data>)listItem);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectNum = position;
                System.out.println(selectNum);
            }
        });

        buttonAdd = (Button) findViewById(R.id.buttonAddItem);
        buttonAdd.setOnClickListener(this);
        buttonAddPosition = (Button) findViewById(R.id.buttonAddItemPosition);
        buttonAddPosition.setOnClickListener(this);
        buttonDelete = (Button) findViewById(R.id.buttonDeleteItem);
        buttonDelete.setOnClickListener(this);
        buttonDeletePosition = (Button) findViewById(R.id.buttonDeleteItemPosition);
        buttonDeletePosition.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonAddItem:
                myAdapter.add(new Data(R.mipmap.ic_launcher,"跪好了听我道歉" + num));
                System.out.println();
                num++;
                break;
            case R.id.buttonAddItemPosition:
                myAdapter.addPosition(2,new Data(R.mipmap.ic_launcher,"OMG" + num));
                num++;
                break;
            case R.id.buttonDeleteItem:
                System.out.println(selectNum);
                myAdapter.removeData((Data)myAdapter.getItem(selectNum));
                break;
            case R.id.buttonDeleteItemPosition:
                myAdapter.removeDataPosition(3);
                break;
        }
    }
}
