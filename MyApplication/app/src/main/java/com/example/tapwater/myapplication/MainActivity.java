package com.example.tapwater.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThird;

    private AutoCompleteTextView acTextView;
    private MultiAutoCompleteTextView macTextView;

    private String[] res = {"apple","application","app","hear","health"};

    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buttonOne = (Button) findViewById(R.id.buttonOne);
        this.buttonTwo = (Button) findViewById(R.id.buttonTwo);
        this.buttonThird = (Button) findViewById(R.id.buttonThird);

        this.acTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,res);
        this.acTextView.setAdapter(adapter);

        this.macTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        this.macTextView.setAdapter(adapter);
        this.macTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        this.toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        this.toggleButton.setOnCheckedChangeListener(this);

        this.buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Button One On Click.");
            }
        });

        MyOnClickListener myOnClickListener = new MyOnClickListener();
//        this.buttonTwo.setOnClickListener((View.OnClickListener) myOnClickListener);

        this.buttonThird.setOnClickListener(this);


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
    public void onClick(View view) {
        System.out.println("Button Third On Click.");
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        System.out.println(compoundButton.isSelected());
        System.out.println(b);

    }
}
