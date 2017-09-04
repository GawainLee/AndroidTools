package com.tapwater.xml;

import com.tapwater.mp3Model.Mp3Info;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

/**
 * Created by Tapwater on 16-1-26.
 * MP3 content handler, pares XML and get info
 */
public class Mp3ListContentHandler extends DefaultHandler {

    private List<Mp3Info> infos = null;
    private Mp3Info mp3Info = null;
    private String tagName = null;

    /**
     * @param infos
     */
    public Mp3ListContentHandler(List<Mp3Info> infos) {
        this.infos = infos;
    }

    /**
     * analysis XML characters
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String tempResult = new String(ch, start, length);
        if (tagName.equals("id"))
        {
            mp3Info.setId(tempResult);
        }
        else if(tagName.equals("mp3.name"))
        {
            mp3Info.setMp3Name(tempResult);
        }
        else if(tagName.equals("mp3.size"))
        {
            mp3Info.setMp3Size(tempResult);
        }
        else if(tagName.equals("lrc.name"))
        {
            mp3Info.setLrcName(tempResult);
        }
        else if(tagName.equals("lrc.size"))
        {
            mp3Info.setLrcSize(tempResult);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("resource"))
        {
            infos.add(mp3Info);
            mp3Info = null;
        }
        tagName = "";
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tagName = localName;
        if (tagName.equals("resource"))
        {
            mp3Info = new Mp3Info();
        }
    }

    public List<Mp3Info> getInfos() {
        return infos;
    }

    public void setInfos(List<Mp3Info> infos) {
        this.infos = infos;
    }
}
