package com.tapwater.revisepopwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonShowPopWindow;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        buttonShowPopWindow = (Button) findViewById(R.id.btn_popwindow);
        buttonShowPopWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopWindow(v);
            }
        });
    }

    private void initPopWindow(View v)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_pop,null,false);
        Button buttonHaha = (Button) view.findViewById(R.id.btn_haha);
        Button buttonXixi = (Button) view.findViewById(R.id.btn_xixi);
        final PopupWindow popupWindow = new PopupWindow
                (view, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setAnimationStyle(R.anim.anim_pop);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.showAsDropDown(v, 50, 0);
        buttonHaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"HAHA",Toast.LENGTH_LONG).show();
            }
        });
        buttonXixi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"XIXI",Toast.LENGTH_LONG).show();
            }
        });
    }
}
