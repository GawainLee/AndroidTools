package com.tapwater.learn_31_xmlreader;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Tapwater on 16-1-21.
 */
public class MyContentHandler extends DefaultHandler {
    private String ID,sex,name,status,address;
    private int salary;
    private String localName;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (localName.equals("id")) {
            ID = new String(ch, start, length);
        } else if (localName.equals("name")) {
            name = new String(ch, start, length);
        } else if (localName.equals("sex")) {
            sex = new String(ch, start, length);
        } else if (localName.equals("status")) {
            status = new String(ch, start, length);
        } else if (localName.equals("address")) {
            address = new String(ch, start, length);
        }else if(localName.equals("salary"))
        {
            salary = Integer.parseInt(new String(ch, start, length));
        }
    }

    @Override
    public void endDocument() throws SAXException {
        Log.i("info", "<--------End Document-------->");
    }

    @Override
    public void startDocument() throws SAXException {
        Log.i("info","<--------Start Document-------->");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.localName = localName;
        if (localName=="worker")
        {
            for(int i = 0; i < attributes.getLength(); i++)
            {
                Log.i("info","<--------Start Element-------->");
                Log.i("info",attributes.getLocalName(i) + " = " + attributes.getValue(i));
                if(attributes.getLocalName(i).equals("id"))
                {
                    ID = attributes.getValue(i);
                }
            }
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName == "worker")
        {
            Log.i("info","<--------End Element-------->");
            printInfo();

        }
    }

    private void printInfo()
    {
        Log.i("info","<--------Print Info-------->");
        Log.i("info","ID: " + ID);
        Log.i("info","Name: " + name);
        Log.i("info","Sex: " + sex);
        Log.i("info","Status: " + status);
        Log.i("info","Address: " + address);
        Log.i("info","Salary: " + salary);
    }
}
