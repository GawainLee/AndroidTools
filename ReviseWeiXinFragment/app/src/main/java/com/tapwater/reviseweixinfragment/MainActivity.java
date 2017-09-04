package com.tapwater.reviseweixinfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ButtomFragment.MyListener {

    Fragment fragmentContent, fragmentBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragment();
    }

    public void setFragment()
    {
        fragmentContent = new WeiXinFragment();
        fragmentBottom = new ButtomFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.fragmentContentPlace,fragmentContent);
//        fragmentTransaction.commit();
        fragmentTransaction.add(R.id.fragmentBottomPlace,fragmentBottom);
        fragmentTransaction.commit();
    }


    @Override
    public void send(String info) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (info.equals("First"))
        {
            Toast.makeText(MainActivity.this,info,Toast.LENGTH_LONG).show();
            fragmentContent = new FriendFragment();
            fragmentTransaction.replace(R.id.fragmentContentPlace,fragmentContent);
            fragmentTransaction.commit();
        }
        if (info.equals("Second"))
        {
            Toast.makeText(MainActivity.this,info,Toast.LENGTH_LONG).show();
            fragmentContent = new WeiXinFragment();
            fragmentTransaction.replace(R.id.fragmentContentPlace,fragmentContent);
            fragmentTransaction.commit();
        }
    }
}
