package com.tapwater.revisefragmentone;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//import android.support.v4.app.Fragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.buttonFragmentOne);
        button2 = (Button) findViewById(R.id.buttonFragmentTwo);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    public void changeFragment(View view)
    {

    }

    @Override
    public void onClick(View view) {
        android.app.Fragment fragment;
        if (view == findViewById(R.id.buttonFragmentOne))
        {
            fragment = new FragmentOne();
            android.app.FragmentManager fragmentManager = getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_place,fragment);
            fragmentTransaction.commit();
        }
        else if(view == findViewById(R.id.buttonFragmentTwo))
        {
            fragment = new FragmentTwo();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_place,fragment);
            fragmentTransaction.commit();
        }
    }
}
