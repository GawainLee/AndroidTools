package com.tapwater.learn_18_fragment_sconde;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TopFragment.TopFragmentListener {

    TopFragment topFragment;
    BottomFragment bottomFragment;
    Button button;
    EditText textViewTop,textViewBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intn();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void intn() {
        topFragment = new TopFragment();
        FragmentManager fragmentManagerTop = getFragmentManager();
        FragmentTransaction fragmentTransactionTop = fragmentManagerTop.beginTransaction();
        fragmentTransactionTop.add(R.id.topFragment,topFragment);
        fragmentTransactionTop.commit();



//        textViewTop = (EditText) findViewById(R.id.editTextTop);
//        textViewBottom = (EditText) findViewById(R.id.editTextBottom);
//        button = (Button) findViewById(R.id.buttonSubmit);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });


        bottomFragment = new BottomFragment();
        FragmentManager fragmentManagerBottom = getFragmentManager();
        FragmentTransaction fragmentTransactionBottom = fragmentManagerBottom.beginTransaction();
        fragmentTransactionBottom.add(R.id.bottomFragment,bottomFragment);
        fragmentTransactionBottom.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void SubmitText(String topText, String bottomText) {

    }
}
