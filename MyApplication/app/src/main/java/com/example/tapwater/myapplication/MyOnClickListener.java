package com.example.tapwater.myapplication;

import android.content.DialogInterface;

/**
 * Created by Tapwater on 15-12-2.
 */
public class MyOnClickListener implements DialogInterface.OnClickListener{
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        System.out.println("Button Two On Click Listener.");
    }
}
