package com.tapwater.learn_21_fragmentpageradapter;

import android.app.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tapwater on 15-12-23.
 */
public class Main extends FragmentActivity implements ViewPager.OnPageChangeListener{

    private List<Fragment> fragmentList;
    private List<String> titleList;

    private PagerTabStrip pagerTabStrip;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new FragmentOne());
        fragmentList.add(new FragmentTwo());
        fragmentList.add(new FragmentThree());
        fragmentList.add(new FragmentFour());

        titleList = new ArrayList<String>();
        titleList.add("Page One");
        titleList.add("Page Two");
        titleList.add("Page Three");
        titleList.add("Page Four");

        pagerTabStrip = (PagerTabStrip) findViewById(R.id.tab_strip);
        pagerTabStrip.setBackgroundColor(Color.GRAY);
        pagerTabStrip.setTextColor(Color.RED);
        pagerTabStrip.setDrawFullUnderline(false);
        pagerTabStrip.setTabIndicatorColor(Color.YELLOW);

        viewPager = (ViewPager) findViewById(R.id.page);

        MyFragmentPageAdapter myFragmentPageAdapter = new MyFragmentPageAdapter(getSupportFragmentManager(),fragmentList,titleList);

//        viewPager.setAdapter(myFragmentPageAdapter);

        MyFragmentPageAdapter myFragmentPageAdapter1 = new MyFragmentPageAdapter(getSupportFragmentManager(),fragmentList,titleList);

        viewPager.setAdapter(myFragmentPageAdapter1);
        viewPager.setOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this,"Page " + (position + 1),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
