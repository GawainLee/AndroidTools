package com.tapwater.reviseviewswitcher;

//
//public class MainActivity extends AppCompatActivity {
//
//    public static final  int NUMBER_PER_SCREEN = 12;
//
//    public static class DataItem
//    {
//        public String dataName;
//        public Drawable drawable;
//    }
//    private ArrayList<DataItem> items = new ArrayList<DataItem>();
//
//    private int screeNo = -1;
//
//    private int screeCount;
//
//    ViewSwitcher viewSwitcher;
//
//    LayoutInflater inflater;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        inflater = LayoutInflater.from(MainActivity.this);
//        for (int i = 0; i < 40; i++)
//        {
//            String lable = " " + i;
//            Drawable drawable = getResources().getDrawable(R.drawable.two);
//            DataItem dataItem = new DataItem();
//            dataItem.dataName = lable;
//            dataItem.drawable = drawable;
//            items.add(dataItem);
//        }
//        screeCount = items.size() % NUMBER_PER_SCREEN == 0 ?
//                items.size() / NUMBER_PER_SCREEN :
//                items.size() / NUMBER_PER_SCREEN + 1;
//
//        viewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
//        viewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
//            @Override
//            public View makeView() {
//                return inflater.inflate(R.layout.slidelistview,null);
//            }
//        });
//        next(null);
//    }
//
//    public void next(View view)
//    {
//        if (screeNo < screeCount - 1)
//        {
//            screeNo++;
//            viewSwitcher.setInAnimation(this,R.anim.slide_in_right);
//            viewSwitcher.setOutAnimation(this,R.anim.slide_out_left);
//            ((GridView)viewSwitcher.getNextView()).setAdapter(adapter);
//            viewSwitcher.showNext();
//        }
//    }
//
//    public void prev (View view)
//    {
//        if (screeNo > 0)
//        {
//            screeNo--;
//            viewSwitcher.setInAnimation(this,R.anim.slide_out_left);
//            viewSwitcher.setOutAnimation(this,R.anim.slide_in_right);
//            ((GridView)viewSwitcher.getNextView()).setAdapter(adapter);
//            viewSwitcher.showPrevious();
//        }
//    }
//
//    private BaseAdapter adapter = new BaseAdapter() {
//        @Override
//        public int getCount() {
//            if (screeNo == screeCount - 1 && items.size() % NUMBER_PER_SCREEN != 0)
//            {
//                return items.size() % NUMBER_PER_SCREEN;
//            }
//            return NUMBER_PER_SCREEN;
//        }
//
//        @Override
//        public DataItem getItem(int i) {
//            return items.get(screeNo * NUMBER_PER_SCREEN + i);
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return i;
//        }
//
//        @Override
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            View view1 = view;
//            if (view == null)
//            {
//                view1 = inflater.inflate(R.layout.labelicon,null);
//            }
//            ImageView imageView = (ImageView) view1.findViewById(R.id.imageView);
//            imageView.setImageDrawable(getItem(i).drawable);
//
//            TextView textView = (TextView) view1.findViewById(R.id.textView);
//            textView.setText(getItem(i).dataName);
//            return view1;
//        }
//    };
//}


import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

public class MainActivity extends Activity
{
    // 定义一个常量，用于显示每屏显示的应用程序数
    public static final int NUMBER_PER_SCREEN = 12;

    // 代表应用程序的内部类，
    public static class DataItem
    {
        // 应用程序名称
        public String dataName;
        // 应用程序图标
        public Drawable drawable;
    }

    // 保存系统所有应用程序的List集合
    private ArrayList<DataItem> items = new ArrayList<DataItem>();
    // 记录当前正在显示第几屏的程序
    private int screenNo = -1;
    // 保存程序所占的总屏数
    private int screenCount;
    ViewSwitcher switcher;
    // 创建LayoutInflater对象
    LayoutInflater inflater;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater = LayoutInflater.from(MainActivity.this);
        // 创建一个包含40个元素的List集合，用于模拟包含40个应用程序
        for (int i = 0; i < 40; i++)
        {
            String label = "" + i;
            Drawable drawable = getResources().getDrawable(
                    R.drawable.two);
            DataItem item = new DataItem();
            item.dataName = label;
            item.drawable = drawable;
            items.add(item);
        }
        // 计算应用程序所占的总屏数。
        // 如果应用程序的数量能整除NUMBER_PER_SCREEN，除法的结果就是总屏数。
        // 如果不能整除，总屏数应该是除法的结果再加1。
        screenCount = items.size() % NUMBER_PER_SCREEN == 0 ?
                items.size()/ NUMBER_PER_SCREEN :
                items.size() / NUMBER_PER_SCREEN    + 1;
        switcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        switcher.setFactory(new ViewSwitcher.ViewFactory()
        {
            // 实际上就是返回一个GridView组件
            @Override
            public View makeView()
            {
                // 加载R.layout.slidelistview组件，实际上就是一个GridView组件。
                return inflater.inflate(R.layout.slidelistview, null);
            }
        });
        // 页面加载时先显示第一屏。
        next(null);
    }

    public void next(View v)
    {
        if (screenNo < screenCount - 1)
        {
            screenNo++;
            // 为ViewSwitcher的组件显示过程设置动画
            switcher.setInAnimation(this, R.anim.slide_in_right);
            // 为ViewSwitcher的组件隐藏过程设置动画
            switcher.setOutAnimation(this, R.anim.slide_out_left);
            // 控制下一屏将要显示的GridView对应的 Adapter
            ((GridView) switcher.getNextView()).setAdapter(adapter);
            // 点击右边按钮，显示下一屏，也可通过手势检测实现显示下一屏.
            switcher.showNext();
        }
    }

    public void prev(View v)
    {
        if (screenNo > 0)
        {
            screenNo--;
            // 为ViewSwitcher的组件显示过程设置动画
            switcher.setInAnimation(this, android.R.anim.slide_in_left);
            // 为ViewSwitcher的组件隐藏过程设置动画
            switcher.setOutAnimation(this, android.R.anim.slide_out_right);
            // 控制下一屏将要显示的GridView对应的 Adapter
            ((GridView) switcher.getNextView()).setAdapter(adapter);
            // 点击左边按钮，显示上一屏，也可通过手势检测实现显示上一屏.
            switcher.showPrevious();
        }
    }

    // 该BaseAdapter负责为每屏显示的GridView提供列表项
    private BaseAdapter adapter = new BaseAdapter()
    {
        @Override
        public int getCount()
        {
            // 如果已经到了最后一屏，且应用程序的数量不能整除NUMBER_PER_SCREEN
            if (screenNo == screenCount - 1
                    && items.size() % NUMBER_PER_SCREEN != 0)
            {
                // 最后一屏显示的程序数为应用程序的数量对NUMBER_PER_SCREEN求余
                return items.size() % NUMBER_PER_SCREEN;
            }
            // 否则每屏显示的程序数量为NUMBER_PER_SCREEN
            return NUMBER_PER_SCREEN;
        }

        @Override
        public DataItem getItem(int position)
        {
            // 根据screenNo计算第position个列表项的数据
            return items.get(screenNo * NUMBER_PER_SCREEN + position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position
                , View convertView, ViewGroup parent)
        {
            View view = convertView;
            if (convertView == null)
            {
                // 加载R.layout.labelicon布局文件
                view = inflater.inflate(R.layout.labelicon, null);
            }
            // 获取R.layout.labelicon布局文件中的ImageView组件，并为之设置图标
            ImageView imageView = (ImageView)
                    view.findViewById(R.id.imageView);
            imageView.setImageDrawable(getItem(position).drawable);
            // 获取R.layout.labelicon布局文件中的TextView组件，并为之设置文本
            TextView textView = (TextView)
                    view.findViewById(R.id.textView);
            textView.setText(getItem(position).dataName);
            return view;
        }
    };
}