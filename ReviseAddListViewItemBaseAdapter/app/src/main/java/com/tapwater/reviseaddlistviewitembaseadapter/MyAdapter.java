package com.tapwater.reviseaddlistviewitembaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by Tapwater on 16-11-17.
 */

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private LinkedList<Data> mData;

    public MyAdapter() {
    }

    public MyAdapter(Context mContext, LinkedList<Data> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {

        System.out.println("Debug");
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHost viewHost = null;
        if (convertView == null)
        {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
            viewHost = new ViewHost();
            viewHost.imageViewHead = (ImageView) convertView.findViewById(R.id.imageViewPlace);
            viewHost.textViewContent = (TextView) convertView.findViewById(R.id.textViewPlace);
            convertView.setTag(viewHost);
        }
        else
        {
            viewHost = (ViewHost) convertView.getTag();
        }
        viewHost.imageViewHead.setBackgroundResource(mData.get(position).getImgID());
        viewHost.textViewContent.setText(mData.get(position).getContent());


        return convertView;
    }

    public void add(Data data)
    {
        if (mData == null)
        {
            mData = new LinkedList<Data>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }

    public void addPosition(int i, Data data)
    {
        if (mData == null)
        {
            mData = new LinkedList<Data>();
        }
        mData.add(i,data);
        notifyDataSetChanged();
    }

    public void removeData (Data data)
    {
        if (mData != null)
        {
            mData.remove(data);
        }
        notifyDataSetChanged();
    }

    public void removeDataPosition(int i)
    {
        if (mData != null)
        {
            mData.remove(i);
        }
        notifyDataSetChanged();
    }

    static class ViewHost
    {
        ImageView imageViewHead;
        TextView textViewContent;
    }
}
