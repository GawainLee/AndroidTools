package com.tapwater.revisealertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
        {
            simple(null);
        }
        return false;
    }

    public void simple(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Simple")
                .setIcon(R.drawable.image1)
                .setMessage("Dialog test \n Second line");
        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public void simpleList(View view)
    {
        Dialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.image2)
                .setTitle("Simlep List")
                .setMessage("Do you like me?")
                .setPositiveButton("Like", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Like you.",Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("Dislike", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Dislike",Toast.LENGTH_LONG).show();
                    }
                })
                .setNeutralButton("So~so", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"So~ So~",Toast.LENGTH_LONG).show();
                    }
                }).create();
        dialog.show();
    }

    public void simpleInput(View view)
    {
        final EditText editText = new EditText(MainActivity.this);
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.image3)
                .setTitle("Simple Input")
                .setView(editText)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,editText.getText().toString(),Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("No", null)
                .show();

    }

    public void multiChoice(View view)
    {

        final String[] strings = new String[]{"One","Two"};
        final int[] selectNum = {0};
        final Dialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Multi Choice")
                .setIcon(R.drawable.image4)
                .setMultiChoiceItems(strings, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        selectNum[0] = i;
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,strings[selectNum[0]],Toast.LENGTH_LONG).show();
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("No",null)
                .create();
        dialog.show();
    }

    public void diyLayout (View view)
    {

        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.dialog_ui,(ViewGroup) findViewById(R.id.dialog_layout));
        final EditText editText = (EditText) layout.findViewById(R.id.editTextBox);
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("DIY Layout")
                .setIcon(R.drawable.image6)
                .setView(layout)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,editText.getText().toString(),Toast.LENGTH_LONG).show();
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }



}
