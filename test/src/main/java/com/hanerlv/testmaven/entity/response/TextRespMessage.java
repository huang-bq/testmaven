package com.hanerlv.testmaven.entity.response;

/**
 * Created by huangbq on 16/9/22.
 */
public class TextRespMessage extends BaseRespMessage{

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    private String Content;
}
