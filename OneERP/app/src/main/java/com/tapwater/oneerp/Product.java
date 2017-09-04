package com.tapwater.oneerp;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Tapwater on 16-1-13.
 */
public class Product extends Activity{

    private TextView textViewColumnName;
    private EditText editTextColumnInfo;
    private static final String DATABASE_NAME = "database.db";

    private int nowPage = 1;
    private static final String tableName = "product";
    private String[] tableColumnsName;
    private ArrayList<String> inputLine;

    SQLiteDatabase database;
    SQLiteFunction sqLiteFunction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);

        textViewColumnName = (TextView) findViewById(R.id.textView);
        editTextColumnInfo = (EditText) findViewById(R.id.editText);
        inputLine = new ArrayList<String>();

        database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        sqLiteFunction = new SQLiteFunction(this,database);
//        String[] tableColumnsType = sqLiteFunction.getColumnsType(tableName);
        tableColumnsName = sqLiteFunction.getColumnsName(tableName);
        textViewColumnName.setText(tableColumnsName[0]);


//        SQLiteDatabase database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
//        SQLiteFunction sqLiteFunction = new SQLiteFunction(this,database);
//        String tableName = "product";
//        String[] tableColumnsName = {"product_number", "product_name", "product_size"};
//        String[] tableColumnsType = {"integer primary key","text","text"};
//        sqLiteFunction.createTable(tableName, tableColumnsName, tableColumnsType);
//
//
//        ArrayList<String> insertLine = new ArrayList();
//        insertLine.add("100");
//        insertLine.add("phone");
//        insertLine.add("23x10");
//        sqLiteFunction.insertWholeLine(tableName,insertLine);
//
//
//        sqLiteFunction.selectAll(tableName);
//        database.close();
    }

    public void setProduct(View view)
    {
        switch (view.getId())
        {
            case R.id.buttonPrevious:
                nowPage--;
                break;
            case R.id.buttonSkip:
                nowPage++;
                break;
            case R.id.buttonNext:
                if (nowPage < 3)
                {
                    inputLine.add(editTextColumnInfo.getText().toString().trim());
                    nowPage++;
                    textViewColumnName.setText(tableColumnsName[nowPage - 1]);
                    editTextColumnInfo.setText("");
                }
                else if(nowPage == 3)
                {
                    sqLiteFunction.insertWholeLine(tableName,inputLine);
                    Toast.makeText(this,"Finished input",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
