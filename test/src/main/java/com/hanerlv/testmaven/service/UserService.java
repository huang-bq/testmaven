package com.hanerlv.testmaven.service;

import com.hanerlv.testmaven.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhongchaohan on 16/9/14.
 */
public interface UserService {
    /**
     * 查找所有用户
     * @return
     * @throws Exception
     */
    List<User> findUser()throws Exception;
}
