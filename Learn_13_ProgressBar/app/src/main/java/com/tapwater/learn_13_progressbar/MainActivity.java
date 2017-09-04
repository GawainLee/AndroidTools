package com.tapwater.learn_13_progressbar;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar progressBar;
    private Button add, reduce, reset,box;
    private TextView textView;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        add = (Button) findViewById(R.id.buttonAdd);
        reduce = (Button) findViewById(R.id.buttonReduce);
        reset = (Button) findViewById(R.id.buttonReset);
        textView = (TextView) findViewById(R.id.textView);
        box = (Button) findViewById(R.id.button);

        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        reset.setOnClickListener(this);
        box.setOnClickListener(this);
        getPercentage();

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

    private void getPercentage() {
        int first = progressBar.getProgress();
        int second = progressBar.getSecondaryProgress();
        int max = progressBar.getMax();
        int firstP = (int)((first/(float)max)*100);
        int secondP = (int)((second/(float)max)*100);
        textView.setText("First: " + firstP +"% Second: " + secondP + "%");
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
        switch (view.getId())
        {
            case R.id.buttonAdd:
                progressBar.incrementProgressBy(5);
                progressBar.incrementSecondaryProgressBy(5);
                break;
            case R.id.buttonReduce:
                progressBar.incrementProgressBy(-5);
                progressBar.incrementSecondaryProgressBy(-5);
                break;
            case R.id.buttonReset:
                progressBar.setProgress(20);
                progressBar.setSecondaryProgress(30);
                break;
            case R.id.button:
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("ProgressBar");
                progressDialog.setMessage("One Android Application is coming.");
                progressDialog.setIcon(R.mipmap.ic_launcher);
                progressDialog.setMax(100);
                progressDialog.incrementProgressBy(30);
                progressDialog.setIndeterminate(false);

                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Button", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog.setCancelable(true);
                progressDialog.show();



                break;
        }
        getPercentage();
    }
}
