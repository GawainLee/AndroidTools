package com.tapwater.learn_14_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Tapwater on 15-12-15.
 */
public class MyFragment2 extends Fragment {
    private TextView textView;
    private Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_one,container,false);
        textView = (TextView) view.findViewById(R.id.textView);
        textView.setText("Dynamic Text");
        button = (Button) view.findViewById(R.id.buttonChange);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Change text in dynamic code.");
            }
        });
        return view;
    }
}
