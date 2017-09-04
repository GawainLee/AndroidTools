package com.tapwater.learn_31_xmlreader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Tapwater on 16-1-21.
 */
public class XMLReaderActivity extends Activity {

    private Button buttonXMLReader;
    private String XMLResult =
//            "<?xml version=”1.0” encoding=”UTF-8”?>" +
            "<workers>" +
            "<worker id='AQ01'>" +
            "<name>Mark</name>" +
            "<sex>Male</sex>" +
            "<status>Manager</status>" +
            "<address>BeiJing</address>" +
            "<salary>50000</salary>" +
            "</worker>" +
            "<worker id='AQ02'>" +
            "<name>Pate</name>" +
            "<sex>Female</sex>" +
            "<status>Shipping</status>" +
            "<address>ShangHai</address>" +
            "<salary>20000</salary>" +
            "</worker>" +
            "</workers>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_reader);

        buttonXMLReader = (Button) findViewById(R.id.buttonXMLReader);
        buttonXMLReader.setOnClickListener(new ReadXMLListener());
    }

    class ReadXMLListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            try {
                XMLReader xmlReader = saxParserFactory.newSAXParser().getXMLReader();
                xmlReader.setContentHandler(new MyContentHandler());
                xmlReader.parse(new InputSource(new StringReader(XMLResult)));
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
