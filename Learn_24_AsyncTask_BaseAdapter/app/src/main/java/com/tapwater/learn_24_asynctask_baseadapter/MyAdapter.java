package com.tapwater.learn_24_asynctask_baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tapwater on 15-12-30.
 */
public class MyAdapter extends BaseAdapter implements AbsListView.OnScrollListener{

    private List<NewsBean> newsBeanList;
    private LayoutInflater layoutInflater;
    private Boolean firstLoad;

    private int startViewImageNum;
    private int endViewImageNum;
    private ImageLoader imageLoader;
    public static String[] allIconURLList;

    public MyAdapter(Context context, List<NewsBean> newsBeanList, ListView listView) {
        this.newsBeanList = newsBeanList;
        this.firstLoad = true;
        listView.setOnScrollListener(this);
        this.imageLoader = new ImageLoader(listView);
        layoutInflater = LayoutInflater.from(context);
        allIconURLList = new String[newsBeanList.size()];
        for (int i = 0; i < newsBeanList.size(); i++)
        {
               allIconURLList[i] = newsBeanList.get(i).newsIcon;
        }
    }

    @Override
    public int getCount() {
        return newsBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return newsBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null)
        {
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.item, null);
            viewHolder.imageViewIcon = (ImageView) view.findViewById(R.id.itemImageView);
            viewHolder.textViewTitle = (TextView) view.findViewById(R.id.titleTextView);
            viewHolder.textViewDetail = (TextView) view.findViewById(R.id.detailTextView);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }
        String imageURL = newsBeanList.get(i).newsIcon;
        viewHolder.imageViewIcon.setImageResource(R.mipmap.ic_launcher);
        viewHolder.imageViewIcon.setTag(imageURL);
//        new ImageLoader().showImageByThread(viewHolder.imageViewIcon,imageURL);
//        new ImageLoader().showImageViewByAsyncTask(viewHolder.imageViewIcon, imageURL);
//        imageLoader.showImageViewByAsyncTask(viewHolder.imageViewIcon,imageURL);
        viewHolder.textViewTitle.setText(newsBeanList.get(i).title);
        viewHolder.textViewDetail.setText(newsBeanList.get(i).Detail);


        return view;
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i)
    {

        if(i == SCROLL_STATE_IDLE)
        {
            //loading
            imageLoader.loadImage(startViewImageNum,endViewImageNum);
        }
        else
        {
            //stop
            imageLoader.cancelAllTask();
        }
    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2)
    {
        startViewImageNum = i;
        endViewImageNum = i1;
        if (firstLoad && i2 >0) {
            imageLoader.loadImage(startViewImageNum,endViewImageNum);
            firstLoad = false;
        }
    }

    class ViewHolder
    {
        public TextView textViewTitle, textViewDetail;
        public ImageView imageViewIcon;
    }
}
