package com.petpetfairy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.petpetfairy.R;
import com.petpetfairy.model.PetListItem;
import com.petpetfairy.tools.RoundedTransformation;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;


public class PetListAdapter extends RecyclerView.Adapter<PetListViewHolder> {
    private Context mContext;
    private ArrayList<PetListItem> mPetListItems;
    private OnItemClickListener mOnItemClickListener;



    public PetListAdapter(Context context, ArrayList<PetListItem> PetListItems,OnItemClickListener onItemClickListener){
        mContext = context;
        mPetListItems = PetListItems;
        mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        return mPetListItems.get(position).getImageType();
    }

    @NonNull
    @Override
    public PetListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        PetListViewHolder petListViewHolder = null;
        switch (i){
            case PetListItem.TYPE_IMAGE_V:
                View view_v = LayoutInflater.from(mContext).inflate(R.layout.pet_list_item_vertical, viewGroup, false);
                petListViewHolder = new PetListViewHolderV(view_v);
                break;
            case PetListItem.TYPE_IMAGE_H:
                View view_h = LayoutInflater.from(mContext).inflate(R.layout.pet_list_item_horizontal, viewGroup, false);
                petListViewHolder = new PetListViewHolderH(view_h);
                break;
        }
        return  petListViewHolder;

//        View view = LayoutInflater.from(mContext).inflate(R.layout.pet_list_item_vertical, viewGroup, false);
//        return new PetListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull @org.jetbrains.annotations.NotNull PetListViewHolder holder, int position) {
        PetListItem PetListItem = mPetListItems.get(position);
        String imageUrl = PetListItem.getPetListItemDetailLink();
        String petName = PetListItem.getPetListItemName();
//        int likes = PetListItem.getPetListItemLike();

        holder.mTextViewPetName.setText(petName);
//        PetListViewHolder.mTextViewLikes.setText("Likes: " + likes);

        Picasso.get().load(imageUrl).fit().centerInside().transform(new RoundedTransformation(10, 0)).into(holder.mImageView);
    }

//    @Override
//    public void onBindViewHolder(@NonNull com.petpetfairy.adapter.PetListAdapter.PetListViewHolder PetListViewHolder, int i) {
//        PetListItem PetListItem = mPetListItems.get(i);
//        String imageUrl = PetListItem.getPetListItemDetailLink();
//        String petName = PetListItem.getPetListItemName();
//        int likes = PetListItem.getPetListItemLike();
//
//        PetListViewHolder.mTextViewPetName.setText(petName);
////        PetListViewHolder.mTextViewLikes.setText("Likes: " + likes);
//
//        Picasso.get().load(imageUrl).fit().centerInside().into(PetListViewHolder.mImageView);
//    }

    @Override
    public int getItemCount() {
        return mPetListItems.size();
    }


    public class PetListViewHolderV extends PetListViewHolder{

        public PetListViewHolderV(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view_vertical);
            mTextViewPetName = itemView.findViewById(R.id.text_view_pet_name_vertical);
//            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mOnItemClickListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public class PetListViewHolderH extends PetListViewHolder{

        public PetListViewHolderH(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view_horizontal);
            mTextViewPetName = itemView.findViewById(R.id.text_view_pet_name_horizontal);
//            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mOnItemClickListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

//    class PetListViewHolderV extends RecyclerView.ViewHolder{
//
//        ImageView mVImageView;
//        TextView mTextViewPetName;
//        ImageView mHImageView;
////        public TextView mTextViewLikes;
//
//
//        public PetListViewHolderV(@NonNull View itemView) {
//            super(itemView);
//            mVImageView = itemView.findViewById(R.id.image_view_vertical);
//            mTextViewPetName = itemView.findViewById(R.id.text_view_pet_name_vertical);
////            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (mOnItemClickListener != null){
//                        int position = getAdapterPosition();
//                        if (position != RecyclerView.NO_POSITION){
//                            mOnItemClickListener.onItemClick(position);
//                        }
//                    }
//                }
//            });
//        }
//    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
