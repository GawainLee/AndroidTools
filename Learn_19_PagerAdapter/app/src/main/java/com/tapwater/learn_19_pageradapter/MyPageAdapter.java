package com.tapwater.learn_19_pageradapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Tapwater on 15-12-22.
 */
public class MyPageAdapter extends PagerAdapter {


    private List<View> viewList;
    private List<String> titleList;

    public MyPageAdapter(List<View> viewList,List<String> titleList)
    {
        this.viewList = viewList;
        this.titleList = titleList;
    }

    /**
     * 返回页卡数量
     * @return
     */
    @Override
    public int getCount() {
        return this.viewList.size();
    }

    /**
     * View是否来自于对象
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    /**
     *实例化一个页卡
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return  viewList.get(position);
    }

    /**
     * 销毁一个页卡
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    /**
     * 得到页卡标题
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
