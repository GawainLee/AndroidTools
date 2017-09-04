package com.tapwater.revisesqlite;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDBOpenHelper myDb;
    DynamicDBOpenHelper dynamicDBOpenHelper;

    EditText editName, editCourse, editMark, editId;
    Button btnSubmit, btnViewAll, buttonUpdate,buttonDelete,buttonTableInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new MyDBOpenHelper(this);

        dynamicDBOpenHelper = new DynamicDBOpenHelper(this);

        init();

    }

    public void init()
    {
        editName = (EditText) findViewById(R.id.editTextName);
        editCourse = (EditText) findViewById(R.id.editTextCourses);
        editMark = (EditText) findViewById(R.id.editTextMark);
        editId = (EditText) findViewById(R.id.editTextId);

        btnSubmit = (Button) findViewById(R.id.buttonSubmit);
        submitData();

        btnViewAll = (Button) findViewById(R.id.buttonViewAll);
        viewAll();

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        updateData();

        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        deleteData();

        buttonTableInfo = (Button) findViewById(R.id.buttonTableInfo);
        tableInfo();
    }


    public void tableInfo()
    {
        buttonTableInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Cursor cursor = dynamicDBOpenHelper.getTableInfo("student_table");
//                if (cursor.getCount() == 0)
//                {
//                    //not message
//                    showMessage("No Data","can not find any data");
//                    return;
//                }
//                StringBuffer buffer = new StringBuffer();
//                while (cursor.moveToNext())
//                {
//                    int columnSNum =  cursor.getColumnCount();
//
//                    for(int i = 0; i < columnSNum; i++)
//                    {
//                        buffer.append(cursor.getColumnName(i) + " : " + cursor.getString(i)+ "\n");
//                    }
//                }
//                //show all
//                showMessage("All Data", buffer.toString());
            }
        });
    }

    public void deleteData()
    {
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Integer deleteRow = myDb.deleteData(editId.getText().toString());
                Integer deleteRow = dynamicDBOpenHelper.deleteData("student_table",editId.getText().toString());
                if (deleteRow > 0)
                {
                    Toast.makeText(MainActivity.this,"Delete Finished",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Delete Error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void updateData()
    {
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                boolean isUpdate = myDb.updateData(editId.getText().toString(),editName.getText().toString(),editCourse.getText().toString(),editMark.getText().toString());

                String[] updateContent = {editId.getText().toString(),editName.getText().toString(),editCourse.getText().toString(),editMark.getText().toString()};

                boolean isUpdate  = dynamicDBOpenHelper.updateData("student_table",updateContent);

                if (isUpdate)
                {
                    Toast.makeText(MainActivity.this,"Update Finished",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Update Error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void submitData()
    {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dynamicDBOpenHelper.getTableInfo("student_table");

                String[] insertContent = {editName.getText().toString(),editCourse.getText().toString(),editMark.getText().toString()};

                boolean is = dynamicDBOpenHelper.insertDataFirstAutoID("student_table",insertContent);

                if (is)
                {
                    Toast.makeText(MainActivity.this,"Inserted Finished",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Inserted Error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void viewAll()
    {
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dynamicDBOpenHelper.getTableInfo("student_table");
                Cursor cursor = dynamicDBOpenHelper.getAllData();
//                Cursor cursor = myDb.getAllData();

                if (cursor.getCount() == 0)
                {
                    //not message
                    showMessage("No Data","can not find any data");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                String[] tableColumnsName = dynamicDBOpenHelper.getTableColumnsName();
                while (cursor.moveToNext())
                {
//                    buffer.append("ID : " + cursor.getString(0) + "\n");
//                    buffer.append("Course : " + cursor.getString(1) + "\n");
//                    buffer.append("Mark : " + cursor.getString(2) + "\n\n");
                    for(int i = 0; i < dynamicDBOpenHelper.getTableColumnNum(); i++)
                    {
                        buffer.append(tableColumnsName[i] + " : " + cursor.getString(i) + "\n");
                    }
                    buffer.append("\n");
                }
                //show all
                showMessage("All Data", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder =  new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
