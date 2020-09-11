package test;

import cn.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.PropertyVetoException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JDBCTemplateCRUDTest {

    @Autowired
    private JdbcTemplate template;

    @Test
    public void testUpdate() throws PropertyVetoException {
        int row = template.update("update account set money = ? where name = ?", 100, "张三");
        System.out.println(row);
    }

    @Test
    public void testDelete() throws PropertyVetoException {
        int row = template.update("delete from account where name = ?", "王五");
        System.out.println(row);
    }

    @Test
    public void testQueryAll() throws PropertyVetoException {
        List<Account> list = template.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(list);
    }

    @Test
    public void testQueryOne() throws PropertyVetoException {
        Account account = template.queryForObject("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), "张三");
        System.out.println(account);
    }

    @Test
    public void testQueryCount() throws PropertyVetoException {
        Integer cnt = template.queryForObject("select count(*) from account", Integer.class);
        System.out.println(cnt);
    }
}
