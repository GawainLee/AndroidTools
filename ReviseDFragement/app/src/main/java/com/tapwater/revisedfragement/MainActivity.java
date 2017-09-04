package com.tapwater.revisedfragement;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout linearLayoutContent;
    private LinearLayout linearLayoutFriend;

    private FriendFragment friendFragment;
    private ContentFragment contentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutContent = (LinearLayout) findViewById(R.id.contentTab);
        linearLayoutFriend = (LinearLayout) findViewById(R.id.friendTab);

        linearLayoutContent.setOnClickListener(this);
        linearLayoutFriend.setOnClickListener(this);

        setDefaultFragment();
    }

    private void setDefaultFragment()
    {
        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        contentFragment = new ContentFragment();
        fragmentTransaction.replace(R.id.fragmentContent,contentFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {



    }
}
