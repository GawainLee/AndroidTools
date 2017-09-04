package com.tapwater.reviseconversation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by Tapwater on 16-11-18.
 */

public class SentenceAdapter extends BaseAdapter {

    private static final int TYPE_FRIEND = 0;
    private static final int TYPE_USER = 1;
    private Context mContext;
    private LinkedList<Object> mData;


    public SentenceAdapter(Context mContext, LinkedList<Object> mData) {

        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        ViewHolderFriend viewHolderFriend = null;
        ViewHolderUser viewHolderUser = null;
        if (convertView == null)
        {
            switch (type)
            {
                case TYPE_FRIEND:
                    viewHolderFriend = new ViewHolderFriend();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.friend_sentence,parent,false);
                    viewHolderFriend.imageViewFriendHead = (ImageView) convertView.findViewById(R.id.imageViewPlaceFriend);
                    viewHolderFriend.textViewFriendSentence = (TextView) convertView.findViewById(R.id.textViewPlaceFriend);
                    convertView.setTag(R.id.Tag_Friend,viewHolderFriend);
                    break;
                case TYPE_USER:
                    viewHolderUser = new ViewHolderUser();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.user_sentence,parent,false);
                    viewHolderUser.textViewUserSentence = (TextView) convertView.findViewById(R.id.textViewPlaceUser);
                    viewHolderUser.imageViewUserHead = (ImageView) convertView.findViewById(R.id.imageViewPlaceUser);
                    convertView.setTag(R.id.Tag_User,viewHolderUser);
                    break;
            }
        }else
        {
            switch (type)
            {
                case TYPE_FRIEND:
                    viewHolderFriend = (ViewHolderFriend) convertView.getTag(R.id.Tag_Friend);
                    break;
                case TYPE_USER:
                    viewHolderUser = (ViewHolderUser) convertView.getTag(R.id.Tag_User);
                    break;

            }
        }

        Object object = mData.get(position);

        switch (type)
        {
            case TYPE_FRIEND:
                FriendSentence friendSentence = (FriendSentence) object;
                if (friendSentence != null)
                {
                    viewHolderFriend.imageViewFriendHead.setBackgroundResource(friendSentence.getImgHead());
                    viewHolderFriend.textViewFriendSentence.setText(friendSentence.getSentence());
                }
                break;
            case TYPE_USER:
                UserSentence userSentence = (UserSentence) object;
                if (userSentence != null)
                {
                    viewHolderUser.textViewUserSentence.setText(userSentence.getSentence());
                    viewHolderUser.imageViewUserHead.setBackgroundResource(userSentence.getImgHead());
                    break;
                }
        }

        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof FriendSentence)
        {
            return TYPE_FRIEND;
        }
        else if (mData.get(position) instanceof UserSentence)
        {
            return TYPE_USER;
        }
        return super.getItemViewType(position);
    }

    private static class ViewHolderFriend
    {
        ImageView imageViewFriendHead;
        TextView textViewFriendSentence;
    }

    private static class ViewHolderUser
    {
        TextView textViewUserSentence;
        ImageView imageViewUserHead;
    }
}
