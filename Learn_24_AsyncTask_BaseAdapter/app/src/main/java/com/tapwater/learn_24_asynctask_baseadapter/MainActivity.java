package com.tapwater.learn_24_asynctask_baseadapter;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private static String url = "http://www.imooc.com/api/teacher?type=4&num=30";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.mainListView);
        //1.实例化和启动线程内部类
        new NewsAsyncTask().execute(url);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * 线程内部类，输入一个String(url地址)，不需要返回中间数据，最后返回所以显示数据(List<NewsBean>)
     */
    class NewsAsyncTask extends AsyncTask<String,Void,List<NewsBean>>
    {

        @Override
        protected List<NewsBean> doInBackground(String... strings) {
            //输入url地址返回所以显示数据的list
            return getJsonData(strings[0]);
        }

        //线程操作完毕后将数据加载到listView里
        @Override
        protected void onPostExecute(List<NewsBean> newsBeans) {
            super.onPostExecute(newsBeans);
            MyAdapter myAdapter = new MyAdapter(MainActivity.this,newsBeans,listView);
            listView.setAdapter(myAdapter);
        }
    }


    /**
     * 输入url地址返回所以显示数据的list
     * @param url
     * @return
     */
    private List<NewsBean> getJsonData(String url)
    {
        //准备好要返回的list对象
        List<NewsBean> newsBeanList = new ArrayList<>();
        try {
            //输入url的inputStream，返回全部显示数据在一个String里
            String jsonString = readStream(new URL(url).openStream());
            //准备好一个JSONObject对象，以便装载JSONArray里的内容
            JSONObject jsonObject;
            //准备好一个NewsBean对象，以便装载从JSONObject里读取的内容
            NewsBean newsBean;

            //将从url读取来的String内容转化为JSONObject
            jsonObject = new JSONObject(jsonString);
            //用JSONArray装载JSONObject里的data对象
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            //遍历所以JSONArray里地JSONObject
            for (int i = 0; i < jsonArray.length(); i++) {
                //用JSONObject装载一个object对象
                jsonObject = jsonArray.getJSONObject(i);
                //实例化newsBean
                newsBean = new NewsBean();
                //将内容加载到newsBean里
                newsBean.newsIcon = jsonObject.getString("picSmall");
                newsBean.title = jsonObject.getString("name");
                newsBean.Detail = jsonObject.getString("description");
                newsBeanList.add(newsBean);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return newsBeanList;
    }

    /**
     * 输入url的inputStream，返回全部显示数据在一个String里
     * @param inputStream
     * @return
     */
    private String readStream(InputStream inputStream) {
        //准备一个inputStream的reader来解析inputStream
        InputStreamReader inputStreamReader;
        //准备一个返回的String对象
        String result = "";
        try {
            //准备一个空行
            String line = "";
            //将inputStream转为inputStreamReader并设定好为utf-8的解析编码
            inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            //将inputStreamReader转化为BufferedReader
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //一行行的读取bufferedReader的内容并将内容加载到返回对象里
            while ((line = bufferedReader.readLine()) != null)
            {
                result += line;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
