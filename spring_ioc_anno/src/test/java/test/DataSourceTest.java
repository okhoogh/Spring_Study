package test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.ResourceBundle;

public class DataSourceTest {

    @Test
    // 测试手动创建C3P0数据源
    public void test1() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///test");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }

    @Test
    // 测试手动创建Druid数据源
    public void test2() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }

    @Test
    // 测试手动创建C3P0数据源(加载配置文件)
    public void test3() throws Exception {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }

    @Test
    // 测试Spring创建C3P0数据源
    public void test4() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ComboPooledDataSource dataSource = (ComboPooledDataSource) app.getBean("dataSource");
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }
}
