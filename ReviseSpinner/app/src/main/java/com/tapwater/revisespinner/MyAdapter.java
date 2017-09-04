package com.tapwater.revisespinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tapwater on 16-11-23.
 */

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Hero> mData;

    public MyAdapter(Context mContext, ArrayList<Hero> mData) {
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
        ViewHolder viewHolder = null;
        if (convertView == null)
        {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.hero_item,parent,false);
            viewHolder.imageViewHeroIcon = (ImageView) convertView.findViewById(R.id.imageViewPlace);
            viewHolder.textViewHeroName = (TextView) convertView.findViewById(R.id.textViewPlace);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageViewHeroIcon.setBackgroundResource(mData.get(position).getHeroIcon());
        viewHolder.textViewHeroName.setText(mData.get(position).getHeroName());
        return convertView;
    }

    private static class ViewHolder
    {
        ImageView imageViewHeroIcon;
        TextView textViewHeroName;
    }
}
