package com.tapwater.learn_19_pageradapter;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tapwater on 15-12-22.
 */
public class Main extends Activity {

    private List<View> viewList;
    private ViewPager pager;

    private PagerTabStrip pagerTabStrip;
    private List<String> titleList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        viewList = new ArrayList<View>();

        View view1 = View.inflate(this,R.layout.view1,null);
        View view2 = View.inflate(this,R.layout.view2,null);
        View view3 = View.inflate(this,R.layout.view3,null);
        View view4 = View.inflate(this,R.layout.view4,null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);

        titleList = new ArrayList<String>();
        titleList.add("First Page");
        titleList.add("Second Page");
        titleList.add("Third Page");
        titleList.add("Fourth Page");

        pagerTabStrip = (PagerTabStrip) findViewById(R.id.tap_strip);
        pagerTabStrip.setBackgroundColor(Color.YELLOW);
        pagerTabStrip.setTextColor(Color.BLUE);
        pagerTabStrip.setDrawFullUnderline(false);
        pagerTabStrip.setTabIndicatorColor(Color.RED);

        pager = (ViewPager) findViewById(R.id.pager);

        MyPageAdapter myPageAdapter = new MyPageAdapter(viewList,titleList);

        pager.setAdapter(myPageAdapter);

    }
}
