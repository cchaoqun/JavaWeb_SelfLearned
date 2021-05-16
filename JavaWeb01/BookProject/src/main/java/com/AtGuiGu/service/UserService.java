package com.AtGuiGu.service;

import com.AtGuiGu.pojo.User;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/10-15:52
 */

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 返回null 说明登录失败
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回true 表示用户名存在
     */
    public boolean existsUsername(String username);

}
