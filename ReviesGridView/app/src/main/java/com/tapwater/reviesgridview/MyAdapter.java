package com.tapwater.reviesgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tapwater on 16-11-22.
 */

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Icon> arrayListIcon;

    public MyAdapter(ArrayList<Icon> arrayListIcon, Context mContext) {
        this.arrayListIcon = arrayListIcon;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return arrayListIcon.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListIcon.get(position);
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_grid_icon,parent,false);
            viewHolder.imageViewIcon = (ImageView) convertView.findViewById(R.id.imageViewPlace);
            viewHolder.textViewIcon = (TextView) convertView.findViewById(R.id.textViewPlace);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageViewIcon.setBackgroundResource(arrayListIcon.get(position).getIconHead());
        viewHolder.textViewIcon.setText(arrayListIcon.get(position).getIconName());

        return convertView;
    }

    private static class ViewHolder
    {
        ImageView imageViewIcon;
        TextView textViewIcon;
    }
}
