package com.tapwater.reviseweixinfragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Tapwater on 16-11-8.
 */

public class ButtomFragment extends Fragment implements View.OnClickListener{

    ImageButton imageButtonFirst,imageButtonSecond,imageButtonThird,imageButtonFourth;

    View view;

    @Override
    public void onAttach(Activity activity) {
        listener = (MyListener)activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_fragment,container,false);
        imageButtonFirst = (ImageButton) view.findViewById(R.id.imageButtonFirst);
        imageButtonSecond = (ImageButton) view.findViewById(R.id.imageButtonSecond);
        imageButtonThird = (ImageButton) view.findViewById(R.id.imageButtonThird);
        imageButtonFourth = (ImageButton) view.findViewById(R.id.imageButtonFourth);
        imageButtonFirst.setOnClickListener(this);
        imageButtonSecond.setOnClickListener(this);
        imageButtonThird.setOnClickListener(this);
        imageButtonFourth.setOnClickListener(this);
        return view;
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id)
        {
            case R.id.imageButtonFirst:
                listener.send("First");
                Toast.makeText(getActivity(),"Bottom Fragment Show",Toast.LENGTH_LONG).show();
                break;
            case R.id.imageButtonSecond:
                listener.send("Second");
                break;
            case R.id.imageButtonThird:
                listener.send("Third");
                break;
            case R.id.imageButtonFourth:
                listener.send("Fourth");
                break;
        }
    }

    public MyListener listener;
    public interface MyListener
    {
        public void send(String info);
    }
}
