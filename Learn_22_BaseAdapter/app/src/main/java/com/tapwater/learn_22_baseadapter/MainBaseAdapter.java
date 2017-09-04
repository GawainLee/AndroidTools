package com.tapwater.learn_22_baseadapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tapwater on 15-12-28.
 */
public class MainBaseAdapter extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        List<ItemBean> itemBeanList = new ArrayList();

        for (int i = 0; i < 20; i++) {
            itemBeanList.add(new ItemBean("Title " + i ,R.mipmap.ic_launcher,"Detail " + i));
        }

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new MyAdapter(this,itemBeanList));
    }
}
