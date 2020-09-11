package test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JDBCTemplateTest {

    @Test
    public void test1() throws PropertyVetoException {
        // 创建数据源对象
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql:///test");
        ds.setUser("root");
        ds.setPassword("root");

        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "insert into account(name, money) values(?, ?)";
        int row = template.update(sql, "张三", 10.12);
        System.out.println(row);
    }

    @Test
    public void test2() throws PropertyVetoException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = app.getBean(JdbcTemplate.class);
        String sql = "insert into account(name, money) values(?, ?)";
        int row = template.update(sql, "王五", 20.12);
        System.out.println(row);
    }
}
