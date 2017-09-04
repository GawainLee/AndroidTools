package com.tapwater.revisefragementtextview;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linearLayoutBottom;

    TextView textView1,textView2,textView3;

    FrameLayout frameLayoutContent;

    MyFragment myFragment1, myFragment2, myFragment3;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayoutContent = (FrameLayout) findViewById(R.id.frameLayout_content);
        fragmentManager = getFragmentManager();

        bindView();

    }

    private void bindView()
    {
        linearLayoutBottom = (LinearLayout) findViewById(R.id.linearLayout_content);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT,1);

        textView1 = new TextView(this);
        textView1.setText("One");
//        textView1.setOnClickListener(this);
        textView1.setGravity(Gravity.CENTER);
        textView1.setClickable(true);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                hideAllFragment(fragmentTransaction);
                setSelected();
                textView1.setSelected(true);
                if (myFragment1 == null)
                {
                    myFragment1 = new MyFragment();
                    fragmentTransaction.add(R.id.frameLayout_content,myFragment1);
                    System.out.println("1");
                }
                else
                {
                    fragmentTransaction.show(myFragment1);
                    System.out.println("11");
                }
            }
        });
        linearLayoutBottom.addView(textView1,params);

        textView2 = new TextView(this);
        textView2.setText("Three");
        textView2.setOnClickListener(this);
        textView2.setGravity(Gravity.CENTER);
        textView2.setClickable(true);
        linearLayoutBottom.addView(textView2,params);

        textView3 = new TextView(this);
        textView3.setText("Two");
        textView3.setOnClickListener(this);
        textView3.setGravity(Gravity.CENTER);
        textView3.setClickable(true);
        linearLayoutBottom.addView(textView3,params);

        textView1.performClick();
    }


    private void setSelected()
    {
        textView1.setSelected(false);
        textView2.setSelected(false);
        textView3.setSelected(false);
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction)
    {
        if (myFragment1 != null)
        {
            fragmentTransaction.hide(myFragment1);
        }
        if (myFragment2 != null)
        {
            fragmentTransaction.hide(myFragment2);
        }
        if (myFragment3 != null)
        {
            fragmentTransaction.hide(myFragment3);
        }
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);

        System.out.println(v.getId() + " "+ textView1.getId() + " " + textView2.getId()+ " "+ textView3.getId());
        if(v.getId() == textView1.getId())
        {
            setSelected();
            textView1.setSelected(true);
            if (myFragment1 == null)
            {
                myFragment1 = new MyFragment();
                fragmentTransaction.add(R.id.frameLayout_content,myFragment1);
                System.out.println("1");
            }
            else
            {
                fragmentTransaction.show(myFragment1);
                System.out.println("11");
            }
        }
        if(v.getId() == textView2.getId())
        {
            setSelected();
            textView2.setSelected(true);
            if (myFragment2 == null)
            {
                myFragment2 = new MyFragment();
                fragmentTransaction.add(R.id.frameLayout_content,myFragment2);
                System.out.println("2");
            }
            else
            {
                fragmentTransaction.show(myFragment2);
                System.out.println("22");
            }
        }
        if(v.getId() == textView3.getId())
        {
            setSelected();
            textView3.setSelected(true);
            if (myFragment3 == null)
            {
                myFragment3 = new MyFragment();
                fragmentTransaction.add(R.id.frameLayout_content,myFragment3);
                System.out.println("3");
            }
            else
            {
                fragmentTransaction.show(myFragment3);
                System.out.println("33");
            }
        }
        fragmentTransaction.commit();
    }
}
