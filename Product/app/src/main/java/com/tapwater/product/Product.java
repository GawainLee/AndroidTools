package com.tapwater.product;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tapwater on 16-1-12.
 */
public class Product extends Activity {

    private TextView textView;
    private EditText editText;
    private Button buttonPrevious,buttonSkip, buttonNext;
    private static final String DATABASE_NAME = "database.db";
    private static final String PRODUCT_DETAIL_TABLE_NAME = "PDDFIL";
    private static final String PRODUCT_TABLE_NAME = "PDTTBL";
//    private String[] oneProductDetail;
    private ArrayList oneProductDetail;
    private int tableColumnNumber;
    private String[] productColumnName;
    private String[] productColumnDetail;
    private int nowSettingPag = 0;
    private SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);
        getProductTableSetting();
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        textView.setText(productColumnName[0]);

    }

    public void setProduct(View view)
    {
        switch (view.getId())
        {
            case R.id.buttonPrevious:
                if(nowSettingPag == 0)
                {

                }
                else
                {
                    nowSettingPag--;
                }
                break;
            case R.id.buttonSkip:
                if (nowSettingPag == (tableColumnNumber - 1))
                {

                }
                else
                {
                    nowSettingPag++;
                    oneProductDetail.add(nowSettingPag,"");

                }
                break;
            case R.id.buttonNext:
                if (nowSettingPag == (tableColumnNumber))
                {
                    insertOneProduct();
                }
                else
                {
                    if (productColumnDetail[nowSettingPag].toUpperCase().equals("STRING"))
                    {
                        oneProductDetail.add(nowSettingPag, editText.getText().toString());
                    }
                    else if(productColumnDetail[nowSettingPag].toUpperCase().equals("INT"))
                    {
                        oneProductDetail.add(nowSettingPag, Integer.parseInt(editText.getText().toString()));
                    }

                    nowSettingPag++;
                    editText.setText("");
                    if(nowSettingPag < tableColumnNumber)
                    {
                        textView.setText(productColumnName[nowSettingPag]);
                    }
                }
                break;
        }
    }

    private void insertOneProduct()
    {
        //insert into userTable( name, sex, age) values ( 'Gawain', 'Male', 29)
        String sql = "insert into ";
        sql +=  PRODUCT_TABLE_NAME + "(";
        for (int i = 0; i < tableColumnNumber; i++)
        {
            sql += productColumnName[i] + ",";
        }
        sql = sql.substring(0,(sql.length()-1));
        sql += ") values (";
        for(int i = 0; i < tableColumnNumber; i++)
        {
            if(productColumnDetail[i].toUpperCase().equals("STRING"))
            {
                sql += "'" + oneProductDetail.get(i) + "',";
            }
            else if(productColumnDetail[i].toUpperCase().equals("INT"))
            {
                sql += oneProductDetail.get(i) + ",";/////
            }
        }
        sql = sql.substring(0,(sql.length()-1));
        sql += ")";
        Log.i("lz", sql);
        database.execSQL("create table if not exists " + PRODUCT_TABLE_NAME + "(" +
                "_id integer primary key autoincrement" +
                ", PDTNUM text not null" +
                ", PDTSZE text not null " +
                ", PDTPRC integer not null)");
        database.execSQL(sql);
        ///////
        Cursor cursor = database.rawQuery("select * from " + PRODUCT_TABLE_NAME,null);
        if (cursor != null)
        {
            String[] tableColumnNames = cursor.getColumnNames();
            while (cursor.moveToNext())
            {
                for(int i = 0; i < tableColumnNames.length; i++)
                {
                    if(productColumnDetail[i].toUpperCase().equals("INT"))
                    {
                        Log.i("lz",  tableColumnNames[i] + ": " + cursor.getInt(cursor.getColumnIndex(tableColumnNames[i])));
                    }
                    else if(productColumnDetail[i].toUpperCase().equals("STRING"))
                    {
                        Log.i("lz",  tableColumnNames[i] + ": " + cursor.getString(cursor.getColumnIndex(tableColumnNames[i])));
                    }

                }
            }
            cursor.close();
        }
        ///
    }

    private void getProductTableSetting()
    {
        database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        database.execSQL(
                "create table if not exists " + PRODUCT_DETAIL_TABLE_NAME + "(" +
                        "_id integer primary key autoincrement" +
                        ", PDDCLM text not null" +
                        ", PDDTYP text not null)");
        database.execSQL("insert into " +PRODUCT_DETAIL_TABLE_NAME+"( PDDCLM, PDDTYP) values ( 'PDTNUM', 'STRING')");
        database.execSQL("insert into " +PRODUCT_DETAIL_TABLE_NAME+"( PDDCLM, PDDTYP) values ( 'PDTSZE', 'STRING')");
        database.execSQL("insert into " +PRODUCT_DETAIL_TABLE_NAME+"( PDDCLM, PDDTYP) values ( 'PDTPRC', 'INT')");

        Cursor cursor = database.rawQuery("Select * from " + PRODUCT_DETAIL_TABLE_NAME, null);
        if (cursor != null)
        {
            String[] columnName = cursor.getColumnNames();
            int lineNumber = cursor.getCount();
            productColumnName = new String[lineNumber];
            productColumnDetail = new String[lineNumber];
            tableColumnNumber = productColumnName.length;
            oneProductDetail = new ArrayList();

            int nowLine = 0;
            while (cursor.moveToNext())
            {
                productColumnName[nowLine] = cursor.getString(cursor.getColumnIndex(columnName[1]));
                productColumnDetail[nowLine] = cursor.getString(cursor.getColumnIndex(columnName[2]));
                nowLine++;
            }
            cursor.close();
        }
    }
}
