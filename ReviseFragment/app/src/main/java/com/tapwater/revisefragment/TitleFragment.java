package com.tapwater.revisefragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Tapwater on 16-10-27.
 */

public class TitleFragment extends Fragment {

    private ImageButton imageButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title,container,false);
        imageButton = (ImageButton) view.findViewById(R.id.id_title_left_btn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Title Fragment",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
