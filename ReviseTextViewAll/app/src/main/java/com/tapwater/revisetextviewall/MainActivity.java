package com.tapwater.revisetextviewall;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewDrawable = (TextView) findViewById(R.id.textViewDrawable);
        Drawable drawable[] = textViewDrawable.getCompoundDrawables();
        drawable[1].setBounds(30,30,30,30);
        textViewDrawable.setCompoundDrawables(drawable[0],drawable[1],drawable[2],drawable[3]);


        TextView textView = (TextView) findViewById(R.id.textPlace);
        String s = "<font color = 'blue'><b>百度一下</b></font><br>";
        s += "<a href = 'http://www.baidu.com'>百度</a>";
        textView.setText(Html.fromHtml(s));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
