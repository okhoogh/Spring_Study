package cn.service.impl;

import cn.dao.UserDao;
import cn.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    //    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void save() {
        userDao.save();
    }
}
