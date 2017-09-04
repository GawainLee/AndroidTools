package com.tapwater.mp3player;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by Tapwater on 16-2-5.
 */
public class MainMp3Activity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TabHost tabHost = getTabHost();
        Intent remoteIntent = new Intent();
        remoteIntent.setClass(MainMp3Activity.this,RemoteMp3ListActivity.class);
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("Remote");
        Resources resources = getResources();
        tabSpec.setIndicator("Remote",resources.getDrawable(android.R.drawable.stat_sys_download));
        tabSpec.setContent(remoteIntent);
        tabHost.addTab(tabSpec);
    }
}
