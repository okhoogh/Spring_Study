package cn.dao.impl;

import cn.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate template;

    public void setJdbcTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void out(String outMan, double money) {
        template.update("update account set money = money - ? where name = ?", money, outMan);
    }

    public void in(String inMan, double money) {
        template.update("update account set money = money + ? where name = ?", money, inMan);
    }
}
