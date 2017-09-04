package com.tapwater.oneerp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Tapwater on 16-1-13.
 */
public class SQLiteFunction {

    private SQLiteDatabase database;
    private Context context;

//    private String tableName;
//    private Cursor cursor;
//    private ArrayList<ArrayList> wholeTable;
//    private int tableLineNumber;
//    private int tableColumnNumber;
//    private String[] columnsName;
//    private String[] columnType;


    public SQLiteFunction(Context context,SQLiteDatabase database)
    {
        this.context = context;
        this.database = database;
    }


    public ArrayList<ArrayList> selectAll(String tableName)
    {
        Cursor cursor = database.rawQuery("Select * from " + tableName, null);
        if (cursor != null)
        {
            String[] columnsName = cursor.getColumnNames();
            ArrayList<ArrayList> wholeTable = new ArrayList<ArrayList>();
            while (cursor.moveToNext())
            {
                ArrayList<String> oneLine = new ArrayList();
                for(int i = 0; i < columnsName.length; i++)
                {
                    oneLine.add(cursor.getString(cursor.getColumnIndex(columnsName[i])));
                }
                wholeTable.add(oneLine);
            }
            cursor.close();
            return wholeTable;
        }
        cursor.close();
        Toast.makeText(context,"Not data in selected",Toast.LENGTH_SHORT).show();
        return null;
    }



    public void insertWholeLine(String tableName, ArrayList insertData)
    {
        Cursor cursor = database.rawQuery("select * from " + tableName + " limit 1",null);
        String[] tableColumnsName;
        String[] tableColumnsType;
        if (cursor != null)
        {
            tableColumnsName = cursor.getColumnNames();
            tableColumnsType = getColumnsType(tableName);
        }
        else
        {
            Toast.makeText(context,"Can not connect table",Toast.LENGTH_SHORT).show();
            return;
        }
        String insertSQL ="insert into " + tableName + "(";
        for (int i = 0; i < tableColumnsName.length; i++)
        {
            insertSQL += tableColumnsName[i] + ",";
        }
        insertSQL = insertSQL.substring(0,(insertSQL.length()-1));
        insertSQL += ") values (";
        for(int i = 0; i < tableColumnsName.length; i++)
        {
            if(tableColumnsType[i].toUpperCase().equals("TEXT"))
            {
                insertSQL += "'" + insertData.get(i) + "',";
            }
            else if(tableColumnsType[i].toUpperCase().equals("INTEGER"))
            {
                insertSQL += insertData.get(i) + ",";/////
            }
        }
        insertSQL = insertSQL.substring(0,(insertSQL.length() - 1));
        insertSQL += ")";
        database.execSQL(insertSQL);
    }

    public void createTable(String createTableName, String[] createTableColumnsName, String[] createTableColumnsType)
    {
        String createTableSQL = "create table if not exists " + createTableName + "(";
        for (int i = 0; i < createTableColumnsName.length; i++)
        {
            createTableSQL += createTableColumnsName[i] + " " + createTableColumnsType[i] + " not null ,";
        }
        createTableSQL = createTableSQL.substring(0,(createTableSQL.length()-1));
        createTableSQL += ")";
        database.execSQL(createTableSQL);
    }

    public String[] getColumnsType(String tableName) {

            String[] columnType = null;
            Cursor c = database.rawQuery("PRAGMA table_info(" + tableName + ")", null);
            if (c != null)
            {
                columnType = new String[c.getCount()];
                int tempColumnNumber = 0;
                while (c.moveToNext())
                {
                    System.out.println("name: " + c.getString(1) + " type: " + c.getString(2));
                    columnType[tempColumnNumber] = c.getString(2);
                    tempColumnNumber++;
                }
            }
            c.close();
        return columnType;
    }

    public String[] getColumnsName(String tableName) {
        String[] columnsName = null;
            Cursor c = database.rawQuery("PRAGMA table_info(" + tableName + ")", null);
            if (c != null)
            {
                columnsName = new String[c.getCount()];
                int tempColumnNumber = 0;
                while (c.moveToNext())
                {
                    System.out.println("name: " + c.getString(1) + " type: " + c.getString(2));
                    columnsName[tempColumnNumber] = c.getString(1);
                    tempColumnNumber++;
                }
            }
            c.close();
        return columnsName;
    }
}
