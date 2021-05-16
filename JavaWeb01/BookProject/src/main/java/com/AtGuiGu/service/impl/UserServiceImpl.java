package com.AtGuiGu.service.impl;

import com.AtGuiGu.dao.impl.UserDao;
import com.AtGuiGu.dao.impl.UserDaoImpl;
import com.AtGuiGu.pojo.User;
import com.AtGuiGu.service.UserService;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/10-15:55
 */

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            //表示没有找到username对应的用户, 可用, 不存在在数据库
            return false;
        }
        return true;
    }
}
