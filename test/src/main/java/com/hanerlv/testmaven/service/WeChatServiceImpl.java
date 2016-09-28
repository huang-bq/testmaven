package com.hanerlv.testmaven.service;



import com.hanerlv.testmaven.common.Constant;
import com.hanerlv.testmaven.common.MessageUtil;
import com.hanerlv.testmaven.entity.request.TextReqMessage;
import com.hanerlv.testmaven.entity.response.TextRespMessage;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by huangbq on 16/9/22.
 */

@Service
public class WeChatServiceImpl implements WeChatService {
    public String processRequest(HttpServletRequest request) {
        String respMessage = null;
        try {
            Map<String,String> requestMap = MessageUtil.parseXml(request);
            String ToUserName = requestMap.get("ToUserName");
            String FromUserName = requestMap.get("FromUserName");
            String MsgType = requestMap.get("MsgType");

            TextRespMessage textRespMessage = new TextRespMessage();
            textRespMessage.setFromUserName(ToUserName);
            textRespMessage.setToUserName(FromUserName);
            textRespMessage.setMsgType(Constant.RESPONSE_MESSAGE_TYPE_TEXT);
            textRespMessage.setCreateTime(new Date().getTime());
            if (MsgType.equals(Constant.REQUEST_MESSAGE_TYPE_TEXT))
            {
                String content = requestMap.get("Content").trim();

                if ("1".equals(content))
                {
                    textRespMessage.setContent("you are NO.1");
                    respMessage=MessageUtil.textMessgeToXml(textRespMessage);
                }else{

                    System.out.println("unknown content:"+content);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return respMessage;
    }
}
