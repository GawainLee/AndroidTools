package com.tapwater.revisebaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

import static com.tapwater.revisebaseadapter.R.id.imageViewHead;

/**
 * Created by Tapwater on 16-11-16.
 */

public class AnimalBaseAdapter extends BaseAdapter {

    private LinkedList<Animal> mData;
    private Context mContext;

    public AnimalBaseAdapter(LinkedList<Animal> mData, Context mContext)
    {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_animal,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.imageViewHead = (ImageView) convertView.findViewById(imageViewHead);
            viewHolder.textViewName = (TextView)convertView.findViewById(R.id.textViewName);
            viewHolder.textViewSaid = (TextView) convertView.findViewById(R.id.textViewSaid);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imageViewHead.setBackgroundResource(mData.get(position).getHead());
        viewHolder.textViewName.setText(mData.get(position).getName());
        viewHolder.textViewSaid.setText(mData.get(position).getSaid());
        
        return convertView;
    }

    static class ViewHolder
    {
        ImageView imageViewHead;
        TextView textViewName;
        TextView textViewSaid;
    }
}
