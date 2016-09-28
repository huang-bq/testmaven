package com.hanerlv.testmaven.common;



import com.hanerlv.testmaven.entity.request.TextReqMessage;
import com.hanerlv.testmaven.entity.response.TextRespMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.DocumentResult;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.Writer;
import java.net.HttpRetryException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huangbq on 16/9/22.
 */
public class MessageUtil {

    private static XStream xstream = new XStream(new XppDriver(){
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out){

                boolean cdata = true;
                protected void writeText(QuickWriter writer,String text){
                    if (cdata){
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    }else {
                        writer.write(text);
                    }
                }
            };
        }

    });
    public static Map<String,String> parseXml(HttpServletRequest request) throws Exception
    {

        Map<String,String> map = new HashMap<String, String>();
//        取得输入流
        InputStream input = request.getInputStream();
//        读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(input);
        Element root = document.getRootElement();
        @SuppressWarnings("unchecked")
        List<Element> elementList = root.elements();
        for (Element element:elementList) {
            map.put(element.getName(),element.getText());
        }
        input.close();
        input=null;
      return map;

    }

    public static String textMessgeToXml(TextRespMessage textMessage)
    {

        xstream.alias("xml",textMessage.getClass());
        return xstream.toXML(textMessage);
    }

}
