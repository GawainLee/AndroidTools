package com.tapwater.revisepopupwindow;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.buttonPopup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow();
            }
        });
    }

    private void showPopupWindow()
    {
        View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.popup_layout,null);
        popupWindow = new PopupWindow
                (contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT,true);
        TextView textView1 = (TextView) contentView.findViewById(R.id.textComputer);
        TextView textView2 = (TextView) contentView.findViewById(R.id.textViewFinance);
        TextView textView3 = (TextView) contentView.findViewById(R.id.textViewManage);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);

        View rootView = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main,null);
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM,0,0);

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id)
        {
            case R.id.textComputer:
            {
                Toast.makeText(MainActivity.this, "Computer", Toast.LENGTH_LONG).show();
                popupWindow.dismiss();
            }
            break;
            case R.id.textViewFinance:
            {
                Toast.makeText(MainActivity.this,"Finance",Toast.LENGTH_LONG).show();
                popupWindow.dismiss();
            }
            break;
            case R.id.textViewManage:
            {
                Toast.makeText(MainActivity.this,"Manage",Toast.LENGTH_LONG).show();
                popupWindow.dismiss();
            }
            break;
        }
    }
}
