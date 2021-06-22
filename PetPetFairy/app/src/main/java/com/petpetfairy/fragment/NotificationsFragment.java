package com.petpetfairy.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.petpetfairy.R;
import com.squareup.picasso.Picasso;

import androidx.annotation.Nullable;


/**
 * Created by Wayne Chen on 2018/5/4.
 */
public class NotificationsFragment extends Fragment {

//    private TextView mTextTitle;
    private ImageView mImageViewNotification;

    public NotificationsFragment() {
        // Requires empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
//        mTextTitle = (TextView) root.findViewById(R.id.text_title_notifications);
        mImageViewNotification = (ImageView) root.findViewById(R.id.notification_detail_image);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String imageUrl = getResources().getString(R.string.notification_detail_image);
        Picasso.get().load(imageUrl).fit().centerInside().into(mImageViewNotification);
//        mTextTitle.setText("Now I see u!");
//        mTextTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((MainActivity) getActivity()).onOpenDetail("Open from Notifications!");
//            }
//        });
    }
}