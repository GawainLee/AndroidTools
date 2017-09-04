package com.tapwater.reviewalertdialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonNormal, buttonListItems, buttonSingleListItems, buttonMultiListItems;
    Context mContext = null;

    private AlertDialog alerDialog = null;
    private AlertDialog.Builder aBuilder = null;

    private boolean[] checkItems = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        bindView();
    }

    private void bindView()
    {
        buttonNormal = (Button) findViewById(R.id.buttonNormalAlertDialog);
        buttonListItems = (Button) findViewById(R.id.buttonListItemsDialog);
        buttonSingleListItems = (Button) findViewById(R.id.buttonSingleListItemsDialog);
        buttonMultiListItems = (Button) findViewById(R.id.buttonMultiListItemsDialog);
        buttonNormal.setOnClickListener(this);
        buttonListItems.setOnClickListener(this);
        buttonSingleListItems.setOnClickListener(this);
        buttonMultiListItems.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        alerDialog = null;
        aBuilder = new AlertDialog.Builder(mContext);
        switch (v.getId())
        {
            case R.id.buttonNormalAlertDialog:
                alerDialog = aBuilder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("Title")
                        .setMessage("Set Message")
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mContext,"Cancel",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mContext,"OK",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNeutralButton("SO~SO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mContext,"SO~SO",Toast.LENGTH_LONG).show();
                            }
                        }).create();
                alerDialog.show();
                break;
            case R.id.buttonListItemsDialog:
                final String[] lesson = new String[]
                        {"Chinese","English","Math","Art"};
                alerDialog = aBuilder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("Set Message List")
                        .setItems(lesson, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),lesson[which],Toast.LENGTH_LONG).show();
                            }
                        }).create();
                alerDialog.show();
                break;
            case R.id.buttonSingleListItemsDialog:
                final String[] fruits = new String[] {"Apple","Orange","Banana","Pear"};
                alerDialog = aBuilder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("Set List Title")
                        .setSingleChoiceItems(fruits, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),fruits[which],Toast.LENGTH_LONG).show();
                            }
                        }).create();
                alerDialog.show();
                break;
            case R.id.buttonMultiListItemsDialog:
                final String[] menu = new String[]{"水煮豆腐", "萝卜牛腩", "酱油鸡", "胡椒猪肚鸡"};
                checkItems = new boolean[]{false,false,false,false};
                alerDialog = aBuilder.setTitle("Menu")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMultiChoiceItems(menu, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(getApplicationContext(),"Select "+menu[which],Toast.LENGTH_LONG).show();
                                checkItems[which] = true;
                            }
                        })
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String allSelected = "";
                                for (int i = 0; i < checkItems.length; i++)
                                {
                                    if (checkItems[i])
                                    {
                                        allSelected += " " + menu[i];
                                    }
                                }
                                Toast.makeText(getApplicationContext(),allSelected,Toast.LENGTH_LONG).show();
                            }
                        }).create();
                alerDialog.show();
                break;
        }
    }
}
