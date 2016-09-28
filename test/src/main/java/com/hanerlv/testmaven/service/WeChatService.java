package com.hanerlv.testmaven.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huangbq on 16/9/22.
 */
public interface WeChatService {
    public String processRequest(HttpServletRequest request);
}
