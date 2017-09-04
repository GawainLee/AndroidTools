package com.tapwater.revisebaseadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Animal> mData = null;
    private Context mConText = null;
    private AnimalBaseAdapter animalBaseAdapter = null;
    private ListView listViewAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConText = MainActivity.this;
        listViewAnimal = (ListView) findViewById(R.id.listViewPlace);
        mData = new LinkedList<Animal>();
        mData.add(new Animal(R.drawable.image1,"Dog","WAOWAO"));
        mData.add(new Animal(R.drawable.image5,"Cat","MAOMAO"));
        mData.add(new Animal(R.drawable.image6,"Bird","JIJIJI"));

        animalBaseAdapter = new AnimalBaseAdapter((LinkedList<Animal>) mData,mConText);
        listViewAnimal.setAdapter(animalBaseAdapter);
    }
}
