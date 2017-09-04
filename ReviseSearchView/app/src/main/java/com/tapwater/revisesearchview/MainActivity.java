package com.tapwater.revisesearchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
//import android.widget.SearchView
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private ListView listView;

    private String[] mStrings = {"aaaa","bbbb","cccc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listViewBox);
        listView.setAdapter(new ArrayAdapter<String>(MainActivity.this,R.layout.simple_list_item_1,mStrings));
        listView.setTextFilterEnabled(true);
//        searchView = (SearchView) findViewById(R.id.searchViewBox);
        searchView = (SearchView) findViewById(R.id.searchViewBox);
        searchView.setIconifiedByDefault(false);
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(TextUtils.isEmpty(query))
                {
                    listView.clearTextFilter();
                }
                else
                {
                    listView.setFilterText(query);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(MainActivity.this,"you select ; " + newText,Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
