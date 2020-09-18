package cn.service.impl;

import cn.domain.Account;
import cn.mapper.AccountMapper;
import cn.service.AccountService;
import cn.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

public class Deprecate_AccountServiceImpl implements AccountService {
    @Override
    public void save(Account account) {
//        SqlSession session = MyBatisUtils.getSqlSession();
//        AccountMapper accountMapper = session.getMapper(AccountMapper.class);
//        accountMapper.save(account);
//        session.commit();
//        session.close();
    }

    @Override
    public List<Account> findAll() {
//        SqlSession session = MyBatisUtils.getSqlSession();
//        AccountMapper accountMapper = session.getMapper(AccountMapper.class);
//        List<Account> accountList = accountMapper.findAll();
//        return accountList;
        return null;
    }
}
