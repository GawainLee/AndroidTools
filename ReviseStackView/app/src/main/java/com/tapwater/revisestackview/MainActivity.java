package com.tapwater.revisestackview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    int [] imageIds = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};

    StackView stackView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stackView = (StackView) findViewById(R.id.stackViewBox);

        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();

        for(int i = 0; i < imageIds.length; i++)
        {
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter
                (MainActivity.this,listItems,R.layout.cell,new String[] {"image"},new int[] {R.id.imageView});
        stackView.setAdapter(simpleAdapter);
    }

    public void prev(View view)
    {
        stackView.showPrevious();
    }
    public void next(View view)
    {
        stackView.showNext();
    }
}
