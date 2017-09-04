package com.tapwater.mp3player;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.tapwater.Service.DownloadService;
import com.tapwater.download.HttpDownloader;
import com.tapwater.mp3Model.Mp3Info;
import com.tapwater.xml.Mp3ListContentHandler;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Tapwater on 16-1-25.
 */
public class RemoteMp3ListActivity extends ListActivity {
    private Button button;
    private List<Mp3Info> mp3Infos = null;

    /**
     * UI handler
     * catch message from thread and update listView
     */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //get listView list info from msg
            List<HashMap<String, String>> list = (List<HashMap<String, String>>) msg.obj;
            //set simpleAdapter
            //1.port of listView
            //2.show info list
            //3.one item layout in listView
            //4.show info key in list
            //5.ID of one item layout input element and order by "number 4 order"
            SimpleAdapter simpleAdapter = new SimpleAdapter(RemoteMp3ListActivity.this, list, R.layout.mp3_item_layout
                    , new String[]{"mp3NameTextView", "mp3SizeTextView"}
                    , new int[]{R.id.mp3NameTextView, R.id.mp3SizeTextView});
            setListAdapter(simpleAdapter);
        }
    };

    /**
     * Runnable override
     * 1.download XML file into String
     * 2.pares result to list
     * 3.get info from mp3Infos list and save into hashMap list
     * 4.save hashMap list into message and send
     */
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //create http download function
            HttpDownloader httpDownloader = new HttpDownloader();
            //get string XML result from URL
            String result = httpDownloader.download(XMLADDRESS);
            //parse string result and get mp3Infos list
            mp3Infos = parse(result);
            //create hashmap list to save update listView info
            List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
            for (int i = 0; i < mp3Infos.size(); i++) {
                Mp3Info mp3Info = mp3Infos.get(i);
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("mp3NameTextView", mp3Info.getLrcName());
                map.put("mp3SizeTextView", mp3Info.getMp3Size());
                list.add(map);
            }
            //get message object
            Message message = Message.obtain();
            //save list into message object
            message.obj = list;
            //send message
            handler.sendMessage(message);
        }
    };
    private static final int UPDATE = 1;
    private static final int ABOUT = 2;
    private String XMLADDRESS = "http://192.168.1.101:8080/mp3/resources.xml";

    /**
     * create Menu button function
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, UPDATE, 1, R.string.mp3_update);
        menu.add(0, ABOUT, 2, R.string.mp3_about);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == UPDATE) {
        } else if (item.getItemId() == ABOUT) {

        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * update listView from URL address and run in thread
     *
     * @param url
     */
    private void downloadXMLString(String url) {
        XMLADDRESS = url;
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remote_mp3_list_activity);

//        button = (Button) findViewById(R.id.xmlDownload);
//        button.setOnClickListener(new downloadXML());
        //update listView
        downloadXMLString(XMLADDRESS);
    }

    class downloadXML implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            downloadXMLString(XMLADDRESS);
        }
    }

    /**
     * parse XML in String and return data in list
     *
     * @param xmlStr
     * @return
     */
    private List<Mp3Info> parse(String xmlStr) {
        //create SAXParseFactory to parse
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        List<Mp3Info> list = null;
        try {
            //create XMLReader and set parse function in SAXParseFactory
            XMLReader xmlReader = saxParserFactory.newSAXParser().getXMLReader();
            //create list to save result
            list = new ArrayList<Mp3Info>();
            //create contentHandler, parse rule and function in this object and set saving result put into list
            Mp3ListContentHandler mp3ListContentHandler = new Mp3ListContentHandler(list);
            //set xmlReader contentHandler
            xmlReader.setContentHandler(mp3ListContentHandler);
            xmlReader.parse(new InputSource(new StringReader(xmlStr)));
            for (int i = 0; i < list.size(); i++) {
                Mp3Info mp3Info = list.get(i);
                System.out.println(mp3Info.toString());
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    //listView is the whole listView
    //view is one item layout
    //position is number of click
    //one item layout id

    /**
     * get the item which user select and past mp3Info to service
     *
     * @param l
     * @param v
     * @param position
     * @param id
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //get select item
        Mp3Info mp3Info = mp3Infos.get(position);
        //create intent
        Intent intent = new Intent();
        //set mp3Info implements Serializable and save mp3 into intent
        intent.putExtra("mp3Info", mp3Info);
        //set intent from this to DownloadService
        intent.setClass(this, DownloadService.class);
        //start service
        startService(intent);
    }
}
