package com.tapwater.learn_18_fragment_sconde;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Tapwater on 15-12-18.
 */
public class TopFragment extends Fragment {

    private Button button;
    private EditText textViewTop,textViewBottom;
//    private String topText, bottomText;

    public TopFragmentListener topFragmentListener;
    public interface TopFragmentListener
    {
        public void SubmitText(String topText, String bottomText);
    }

    @Override
    public void onAttach(Context context) {
        topFragmentListener = (TopFragmentListener) getActivity();
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_fragment_layout,container,false);
        button = (Button) view.findViewById(R.id.buttonSubmit);

        textViewTop =(EditText) view.findViewById(R.id.editTextTop);
        textViewBottom = (EditText)view.findViewById(R.id.editTextBottom);


        return view;
    }


}
