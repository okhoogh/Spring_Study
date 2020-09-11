package cn.service.impl;

import cn.dao.AccountDao;
import cn.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(String outMan, String inMan, double money) {
        // (开启事务)
        accountDao.out(outMan, money);
//        int i = 3 / 0;
        accountDao.in(inMan, money);
        // (提交事务)
    }
}
