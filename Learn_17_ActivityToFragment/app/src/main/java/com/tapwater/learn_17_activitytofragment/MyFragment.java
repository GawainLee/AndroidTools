package com.tapwater.learn_17_activitytofragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Tapwater on 15-12-18.
 */
public class MyFragment extends android.app.Fragment {

    private TextView textViewResult;

    private String fragmentToActivity = "Thanks";

    public MyFragmentListener myFragmentListener;
    public interface MyFragmentListener
    {
        public void backResult(String result);
    }

    @Override
    public void onAttach(Activity activity) {
        myFragmentListener = (MyFragmentListener) activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.show_fragment_layout,container,false);

        textViewResult = (TextView) view.findViewById(R.id.textViewResult);
        String result = getArguments().get("result").toString();
        textViewResult.setText(result);
        Toast.makeText(getActivity(),"Get message.",Toast.LENGTH_SHORT).show();
        myFragmentListener.backResult(fragmentToActivity);
        Toast.makeText(getActivity(),"send code to activity :" + fragmentToActivity,Toast.LENGTH_SHORT).show();
        return view;
    }
}
