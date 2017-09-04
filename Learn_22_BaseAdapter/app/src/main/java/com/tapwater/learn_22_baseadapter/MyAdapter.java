package com.tapwater.learn_22_baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tapwater on 15-12-28.
 */
public class MyAdapter extends BaseAdapter {

    private List<ItemBean> itemBeanList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, List<ItemBean> itemBeanList) {
        this.itemBeanList = itemBeanList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //fist
//        View v = layoutInflater.inflate(R.layout.item,null);
//        ImageView imageView =(ImageView) v.findViewById(R.id.imageViewItem);
//        TextView textViewTitle = (TextView) v.findViewById(R.id.textViewTitle);
//        TextView textViewDetail = (TextView) v.findViewById(R.id.textViewDetail);
//
//        ItemBean itemBean = itemBeanList.get(i);
//        imageView.setImageResource(itemBean.getItemImageSrc());
//        textViewTitle.setText(itemBean.getItemTitle());
//        textViewDetail.setText(itemBean.getItemContent());
//
//        return v;
        //first

//        //second
//        if(view == null)
//        {
//            view = layoutInflater.inflate(R.layout.item,null);
//        }
//        ImageView imageView =(ImageView) view.findViewById(R.id.imageViewItem);
//        TextView textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
//        TextView textViewDetail = (TextView) view.findViewById(R.id.textViewDetail);
//
//        ItemBean itemBean = itemBeanList.get(i);
//        imageView.setImageResource(itemBean.getItemImageSrc());
//        textViewTitle.setText(itemBean.getItemTitle());
//        textViewDetail.setText(itemBean.getItemContent());
//        return view;
//        //second

        //Third
        ViewHolder viewHolder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imageViewItem);
            viewHolder.textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
            viewHolder.textViewDetail = (TextView) view.findViewById(R.id.textViewDetail);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();

        }
        ItemBean itemBean = itemBeanList.get(i);
        viewHolder.imageView.setImageResource(itemBean.getItemImageSrc());
        viewHolder.textViewTitle.setText(itemBean.getItemTitle());
        viewHolder.textViewDetail.setText(itemBean.getItemContent());
        return view;

        //Third
    }

    class ViewHolder
    {
        public ImageView imageView;
        public TextView textViewTitle,textViewDetail;
    }
}