package com.petpetfairy.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.petpetfairy.R;

import androidx.annotation.Nullable;

public class DashboardFragment extends Fragment {

    private TextView mTextTitle;
    private TextView mTextDetail;

    public DashboardFragment() {
        // Requires empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mTextTitle = (TextView) root.findViewById(R.id.text_title_dashboard);
        mTextDetail = (TextView) root.findViewById(R.id.text_detail_dashboard);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mTextTitle.setText("About Us");

//        mTextTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((MainActivity) getActivity()).onOpenDetail("Open from Dashboard!");
//            }
//        });
    }
}
