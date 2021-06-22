package com.petpetfairy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public  abstract class PetListViewHolder extends RecyclerView.ViewHolder {
    public ImageView mImageView;
    public TextView mTextViewPetName;
    public PetListViewHolder(View itemView) {
        super(itemView);

    }
}
