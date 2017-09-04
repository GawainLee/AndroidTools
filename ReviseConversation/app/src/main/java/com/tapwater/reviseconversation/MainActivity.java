package com.tapwater.reviseconversation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private static final int TYPE_FRIEND = 0;
    private static final int TYPE_USER = 1;
    private ListView listView;
    private LinkedList<Object> mData;
    private SentenceAdapter sentenceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mData = new LinkedList<Object>();
        for (int i = 0; i < 20; i++)
        {
            switch ((int)(Math.random() * 2))
            {
                case TYPE_FRIEND:
                    mData.add(new FriendSentence(R.mipmap.ic_launcher,"Friend"));
                    break;
                case TYPE_USER:
                    mData.add(new UserSentence(R.mipmap.ic_launcher,"User"));
                    break;
            }
        }
        listView = (ListView) findViewById(R.id.listViewPlace);
        sentenceAdapter = new SentenceAdapter(this,mData);
        listView.setAdapter(sentenceAdapter);
    }
}
