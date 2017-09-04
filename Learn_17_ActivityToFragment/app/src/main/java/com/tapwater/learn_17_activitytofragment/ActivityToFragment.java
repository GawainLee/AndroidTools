package com.tapwater.learn_17_activitytofragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Tapwater on 15-12-18.
 */
public class ActivityToFragment extends Activity implements MyFragment.MyFragmentListener{

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_fragment);

        textView = (TextView) findViewById(R.id.editTextEnter);
        button = (Button) findViewById(R.id.buttonSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyFragment myFragment = new MyFragment();
                Bundle bundle = new Bundle();
                bundle.putString("result",textView.getText().toString());
                myFragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.activity_to_fragment,myFragment);
                fragmentTransaction.commit();
                Toast.makeText(ActivityToFragment.this
                        ,"Send message " + textView.getText().toString()
                        ,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void backResult(String result) {
        Toast.makeText(this,"get code from fragment :" + result,Toast.LENGTH_SHORT).show();
    }
}
