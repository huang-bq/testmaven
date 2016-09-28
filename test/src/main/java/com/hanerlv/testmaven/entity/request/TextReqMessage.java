package com.hanerlv.testmaven.entity.request;


/**
 * Created by huangbq on 16/9/22.
 */
public class TextReqMessage extends BaseReqMessage {

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;


}

